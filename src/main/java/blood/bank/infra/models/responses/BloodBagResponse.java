package blood.bank.infra.models.responses;

import blood.bank.domain.entities.bloodBag.BloodBag;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BloodBagResponse {

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

    private DonationResponse donation;

    public BloodBagResponse(BloodBag bloodBag) {
        this.donation = new DonationResponse(bloodBag.getDonation());
        this.bloodType = bloodBag.getBloodType();
        this.bloodComponent = bloodBag.getBloodComponent();
        this.bagVolume = bloodBag.getBagVolume();
        this.collectionDate = bloodBag.getCollectionDate();
        this.expirationDate = bloodBag.getExpirationDate();
        this.bagStatus = bloodBag.getBagStatus();
        this.testResult = bloodBag.getTestResult();
        this.freezerNumber = bloodBag.getFreezerNumber();
        this.batchCode = bloodBag.getBatchCode();
        this.complianceStatus = bloodBag.getComplianceStatus();
        this.notes = bloodBag.getNotes();
        this.processingDate = bloodBag.getProcessingDate();
    }

    public DonationResponse getDonation() {
        return donation;
    }

    public void setDonation(DonationResponse donation) {
        this.donation = donation;
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
