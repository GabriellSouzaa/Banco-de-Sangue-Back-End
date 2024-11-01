package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
}
