package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.mappers.DonationEntityMapper;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.repositories.DonationRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DonationRepositoryJpa implements DonationRepositoryGateway {

    private final DonationRepository donationRepository;


    public DonationRepositoryJpa(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> getDonations() {
        List<DonationEntity> donationEntities = this.donationRepository.findAll();
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
                .sorted((d1, d2) -> d1.getDateDonation().compareTo(d2.getDateDonation()))
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
}
