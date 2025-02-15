package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.models.requests.BloodBagRequest;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.repositories.BloodBagRepository;
import blood.bank.infra.persistence.repositories.DonationRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import jakarta.persistence.EntityNotFoundException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BloodBagRepositoryJpa implements BloodBagRepositoryGateway {

    private final BloodBagRepository bloodBagRepository;

    private final JdbcTemplate jdbcTemplate;

    private final DonationRepository donationRepository;

    public BloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, JdbcTemplate jdbcTemplate, DonationRepository donationRepository) {
        this.bloodBagRepository = bloodBagRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.donationRepository = donationRepository;
    }

    @Override
    public List<BloodBag> getBloodBags() {
        List<BloodBagEntity> bloodBags = bloodBagRepository.findAll();
        return bloodBags.stream().map(BloodBagEntityMapper::toBloodBag).collect(Collectors.toList());
    }

    @Override
    public void deleteExpiredBloodBags() {
        String sql = "DELETE FROM bolsa_de_sangue WHERE data_validade < ?";
        jdbcTemplate.update(sql, LocalDate.now());
    }

    @Override
    public void createBloodBag(BloodBagRequest bloodBagRequest) {
        BloodBagEntity bloodBag = new BloodBagEntity();
        populateBloodBagEntity(bloodBag, bloodBagRequest);
        bloodBagRepository.save(bloodBag);
    }

    @Override
    public void updateBloodBag(String batchCode, BloodBagRequest bloodBagRequest) {
        BloodBagEntity bloodBag = bloodBagRepository.findBloodBagEntityByBatchCode(batchCode);
        populateBloodBagEntity(bloodBag, bloodBagRequest);
        bloodBagRepository.save(bloodBag);
    }

    private void populateBloodBagEntity(BloodBagEntity bloodBag, BloodBagRequest bloodBagRequest) {
        DonationEntity donation = donationRepository.findById(bloodBagRequest.getDonationId())
                .orElseThrow(() -> new RuntimeException("Donation not found"));
        bloodBag.setDonation(donation);
        bloodBag.setBloodType(bloodBagRequest.getBloodType());
        bloodBag.setBloodComponent(bloodBagRequest.getBloodComponent());
        bloodBag.setBagVolume(bloodBagRequest.getBagVolume());
        bloodBag.setCollectionDate(bloodBagRequest.getCollectionDate());
        bloodBag.setExpirationDate(bloodBagRequest.getExpirationDate());
        bloodBag.setBagStatus(bloodBagRequest.getBagStatus());
        bloodBag.setTestResult(bloodBagRequest.getTestResult());
        bloodBag.setFreezerNumber(bloodBagRequest.getFreezerNumber());
        bloodBag.setBatchCode(bloodBagRequest.getBatchCode());
        bloodBag.setComplianceStatus(bloodBagRequest.getComplianceStatus());
        bloodBag.setNotes(bloodBagRequest.getNotes());
        bloodBag.setProcessingDate(bloodBagRequest.getProcessingDate());
    }

    @Override
    public void deleteBloodBag(String batchCode) {
        String sql = "DELETE FROM bolsa_de_sangue WHERE cod_lote = ?";
        int rowsAffected = jdbcTemplate.update(sql, batchCode);

        if (rowsAffected == 0) {
            throw new EntityNotFoundException("Bolsa de sangue com código de lote " + batchCode + " não encontrada.");
        }
    }


    @Override
    public ResponseEntity<byte[]> generateReportBloodBag() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/bloodBag.jrxml")).getFile());

        List<BloodBag> bloodBags = this.getBloodBags();

        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource bloodBagsJrBean = new JRBeanCollectionDataSource(bloodBags);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("bloodBag", bloodBagsJrBean);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);
        byte[] bytes = JasperReportUtils.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return JasperReportUtils.retornaResponseEntityRelatorio(bytes);
    }

}

