package blood.bank.infra.models.requests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BloodBagRequest {

    private List<DonationRequest> donations;

    private String bloodType;

    private String bloodComponent;

    private String bagVolume;

    private LocalDate collectionDate;

    private LocalDate expirationDate;

    private String bagStatus;

    private String testResult;

    private String freezerNumber;

    private String batchCode;

    private String complianceStatus;

    private String notes;

    private LocalDateTime processingDate;

    public List<DonationRequest> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationRequest> donations) {
        this.donations = donations;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodComponent() {
        return bloodComponent;
    }

    public void setBloodComponent(String bloodComponent) {
        this.bloodComponent = bloodComponent;
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

    public String getFreezerNumber() {
        return freezerNumber;
    }

    public void setFreezerNumber(String freezerNumber) {
        this.freezerNumber = freezerNumber;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
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
}
