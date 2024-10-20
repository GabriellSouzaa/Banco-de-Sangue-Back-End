package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bolsa_de_sangue")
public class BloodBagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bolsa_de_sangue")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doacao")
    private List<DonationEntity> donations;

    @Column(name = "tipo_sanguineo")
    private String bloodType;

    @Column(name = "componente_sanguineo")
    private String bloodComponent;

    @Column(name = "volume_bolsa")
    private String bagVolume;

    @Column(name = "data_coleta")
    private LocalDate collectionDate;

    @Column(name = "data_validade")
    private LocalDate expirationDate;

    @Column(name = "status_bolsa")
    private String bagStatus;

    @Column(name = "resultado_teste")
    private String testResult;

    @Column(name = "numero_freezer")
    private String freezerNumber;

    @Column(name = "cod_lote")
    private String batchCode;

    @Column(name = "status_conformidade")
    private String complianceStatus;

    @Column(name = "notas")
    private String notes;

    @Column(name = "data_processamento")
    private LocalDateTime processingDate;

    public BloodBagEntity() {

    }

    public BloodBagEntity(List<DonationEntity> donations, String bloodType, String bloodComponent, String bagVolume, LocalDate collectionDate, LocalDate expirationDate, String bagStatus, String testResult, String freezerNumber, String batchCode, String complianceStatus, String notes, LocalDateTime processingDate) {
        this.donations = donations;
        this.bloodType = bloodType;
        this.bloodComponent = bloodComponent;
        this.bagVolume = bagVolume;
        this.collectionDate = collectionDate;
        this.expirationDate = expirationDate;
        this.bagStatus = bagStatus;
        this.testResult = testResult;
        this.freezerNumber = freezerNumber;
        this.batchCode = batchCode;
        this.complianceStatus = complianceStatus;
        this.notes = notes;
        this.processingDate = processingDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DonationEntity> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationEntity> donations) {
        this.donations = donations;
    }

    public String getBloodComponent() {
        return bloodComponent;
    }

    public void setBloodComponent(String bloodComponent) {
        this.bloodComponent = bloodComponent;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBagVolume() {
        return bagVolume;
    }

    public void setBagVolume(String bagVolume) {
        this.bagVolume = bagVolume;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBagStatus() {
        return bagStatus;
    }

    public void setBagStatus(String bagStatus) {
        this.bagStatus = bagStatus;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(LocalDateTime processingDate) {
        this.processingDate = processingDate;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public String getFreezerNumber() {
        return freezerNumber;
    }

    public void setFreezerNumber(String freezerNumber) {
        this.freezerNumber = freezerNumber;
    }
}
