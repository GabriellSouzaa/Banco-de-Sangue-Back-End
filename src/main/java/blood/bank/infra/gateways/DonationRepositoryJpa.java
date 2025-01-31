package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.mappers.DonationEntityMapper;
import blood.bank.infra.models.requests.DonationRequest;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.repositories.DonationRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DonationRepositoryJpa implements DonationRepositoryGateway {

    private final DonationRepository donationRepository;

    private final DonorRepository donorRepository;


    public DonationRepositoryJpa(DonationRepository donationRepository, DonorRepository donorRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
    }

    @Override
    public List<Donation> getDonations() {
        List<DonationEntity> donationEntities = this.donationRepository.findAll();
        return donationEntities.stream().map(DonationEntityMapper::toDonation).collect(Collectors.toList());
    }

    @Override
    public List<Donation> getDonorDonations(Long idDonor) {
        DonorEntity donor = this.donorRepository.findById(idDonor).orElseThrow(() -> new RuntimeException("Não Existe Doador com ess Id"));
        List<DonationEntity> donationEntities = this.donationRepository.findAllByDonorId(donor.getId());
        return donationEntities.stream().map(DonationEntityMapper::toDonation).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<byte[]> generateReportDonationsMonth() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/donation.jrxml")).getFile());

        List<Donation> donations = this.getDonations();
        List<Donation> donationsMonth = donations.stream()
                .filter(d -> d.getDateDonation().getMonth() == LocalDate.now().getMonth() &&
                        d.getDateDonation().getYear() == LocalDate.now().getYear())
                .sorted(Comparator.comparing(Donation::getDateDonation))
                .toList();

        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource donorActiveAndInactive = new JRBeanCollectionDataSource(donationsMonth);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("donations", donorActiveAndInactive);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);
        byte[] bytes = JasperReportUtils.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return JasperReportUtils.retornaResponseEntityRelatorio(bytes);
    }

    @Override
    public void createDonation(Long idDonor, DonationRequest donationRequest) {
        DonorEntity donor = this.donorRepository.findById(idDonor).orElseThrow(() -> new RuntimeException("Não Existe Doador com ess Id"));
        DonationEntity donation = new DonationEntity();
        donation.setDateDonation(donationRequest.getDateDonation());
        donation.setDonor(donor);
        donation.setDateDonation(LocalDate.now());
        donation.setDonatioType(donationRequest.getDonatioType());
        donation.setQuantityCollected(donationRequest.getQuantityCollected());
        donation.setDonationStatus(donationRequest.getDonationStatus());
        donation.setObservation(donationRequest.getObservation());
        donation.setDonationScore(donationRequest.getDonationScore());
        donationRepository.save(donation);

    }

    @Override
    public void updateDonation(Long id, DonationRequest donationRequest) {
        DonationEntity donation = this.donationRepository.findById(id).orElseThrow(
                () ->  new RuntimeException("Não Existe Doação com esse id!")
        );
        donation.setDateDonation(donationRequest.getDateDonation());
        donation.setDonor(donation.getDonor());
        donation.setDateDonation(donationRequest.getDateDonation());
        donation.setDonatioType(donationRequest.getDonatioType());
        donation.setQuantityCollected(donationRequest.getQuantityCollected());
        donation.setDonationStatus(donationRequest.getDonationStatus());
        donation.setObservation(donationRequest.getObservation());
        donation.setDonationScore(donationRequest.getDonationScore());
        donationRepository.save(donation);
    }

    @Override
    public void deleteDonation(Long id) {
        DonationEntity donation = this.donationRepository.findById(id).orElseThrow(
                () ->  new RuntimeException("Não Existe Doação com esse id!")
        );
        this.donationRepository.delete(donation);
    }

    @Override
    public Integer getDonorPosition(Long idDonor) {

        List<DonationEntity> donationEntities = donationRepository.findAllByOrderByDonorIdAsc();
        Map<Long, Long> ranking = donationEntities.stream()
                .collect(Collectors.groupingBy(d -> d.getDonor().getId(), Collectors.counting()));

        List<Map.Entry<Long, Long>> rankingList = ranking.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .toList();

        for (int i = 0; i < rankingList.size(); i++) {
            if (rankingList.get(i).getKey().equals(idDonor)) {
                return i + 1;
            }
        }
        return -1;
    }
}
