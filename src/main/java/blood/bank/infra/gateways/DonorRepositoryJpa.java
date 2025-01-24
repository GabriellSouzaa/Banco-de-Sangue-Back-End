package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.models.requests.DonorRequest;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.PeopleEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import jakarta.persistence.EntityNotFoundException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DonorRepositoryJpa implements DonorRepositoryGateway {

    private final DonorRepository donorRepository;

    private final DonorMapper donorMapper;

    public DonorRepositoryJpa(DonorRepository donorRepository, DonorMapper donorMapper) {
        this.donorRepository = donorRepository;
        this.donorMapper = donorMapper;
    }

    @Override
    public List<Donor> getDonors() {
        List<DonorEntity> donors = donorRepository.findAll();
        return donors.stream().map(DonorMapper::toDonor).collect(Collectors.toList());
    }

    @Override
    public Donor awardPoints(String donorFullName, String donorEmail, Long points) {
        DonorEntity donorEntity = donorRepository.findDonorEntityByPeople_FullNameAndPeople_Email(donorFullName, donorEmail);
        donorEntity.setbCoinsBalance(donorEntity.getbCoinsBalance() + points);
        return DonorMapper.toDonor(donorRepository.save(donorEntity));
    }

    @Override
    public List<Donor> getAvailableDonors() {
        List<DonorEntity> donors = donorRepository.findAll();
        return donors.stream().filter(this::isDonorElegible).map(DonorMapper::toDonor).collect(Collectors.toList());
    }

    @Override
    public boolean isDonorElegible(DonorEntity donor) {
        long daysSinceLastDonation = ChronoUnit.DAYS.between(donor.getLastDonationDate(), LocalDate.now());
        if(donor.getPeople().getGender().equals("Masculino")){
            return daysSinceLastDonation >= 60;
        } else if(donor.getPeople().getGender().equals("Feminino")){
            return daysSinceLastDonation >= 90;
        }
        return false;
    }

    @Override
    public ResponseEntity<byte[]> generateReportOnActiveAndInactiveDonors() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/donor.jrxml")).getFile());

        List<Donor> donors = this.getDonors();

        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource donorActiveAndInactive = new JRBeanCollectionDataSource(donors);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("donors", donorActiveAndInactive);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);
        byte[] bytes = JasperReportUtils.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return JasperReportUtils.retornaResponseEntityRelatorio(bytes);
    }

    @Override
    public Donor createDonor(DonorRequest donorRequest) {
        DonorEntity donorEntity = new DonorEntity();
        PeopleEntity peopleEntity = new PeopleEntity();

        peopleEntity.setFullName(donorRequest.getPeople().getFullName());
        peopleEntity.setDateOfBirth(donorRequest.getPeople().getDateOfBirth());
        peopleEntity.setGender(donorRequest.getPeople().getGender());
        peopleEntity.setEmail(donorRequest.getPeople().getEmail());
        donorEntity.setPeople(peopleEntity);
        donorEntity.setBloodType(donorRequest.getBloodType());
        donorEntity.setRegisterDate(LocalDate.now());
        donorEntity.setLastDonationDate(donorRequest.getLastDonationDate());
        donorEntity.setNumberOfDonations(0L);
        donorEntity.setEligibility(true);
        donorEntity.setMedicalNotes("");
        donorEntity.setbCoinsBalance(0L);
        donorEntity.setImage("");

        return DonorMapper.toDonor(donorRepository.save(donorEntity));
    }

    @Override
    public void updateDonor(Long donorId, DonorRequest donorRequest) {
        DonorEntity donorEntity = donorRepository.findById(donorId)
                .orElseThrow(() -> new EntityNotFoundException("Doador não encontrado com o id: " + donorId));

        PeopleEntity peopleEntity = donorEntity.getPeople();
        peopleEntity.setFullName(donorRequest.getPeople().getFullName());
        peopleEntity.setDateOfBirth(donorRequest.getPeople().getDateOfBirth());
        peopleEntity.setGender(donorRequest.getPeople().getGender());
        peopleEntity.setEmail(donorRequest.getPeople().getEmail());

        donorEntity.setBloodType(donorRequest.getBloodType());
        donorEntity.setRegisterDate(donorRequest.getRegisterDate());
        donorEntity.setLastDonationDate(donorRequest.getLastDonationDate());
        donorEntity.setNumberOfDonations(donorRequest.getNumberOfDonations());
        donorEntity.setEligibility(donorRequest.getEligibility());
        donorEntity.setMedicalNotes(donorRequest.getMedicalNotes());
        donorEntity.setbCoinsBalance(donorRequest.getbCoinsBalance());
        donorEntity.setImage(donorRequest.getImage());

        donorRepository.save(donorEntity);
    }

    @Override
    public void deleteDonor(Long donorId) {
        DonorEntity donorEntity = donorRepository.findById(donorId)
                .orElseThrow(() -> new EntityNotFoundException("Doador não encontrado com o id: " + donorId));

        donorRepository.delete(donorEntity);
    }

}
