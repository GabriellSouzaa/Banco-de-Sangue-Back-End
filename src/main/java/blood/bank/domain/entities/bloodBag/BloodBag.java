package blood.bank.domain.entities.bloodBag;

import blood.bank.domain.entities.donation.Donation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BloodBag {

    private Donation donation;

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

    public BloodBag(Donation donation, String bloodType, String bloodComponent, String bagVolume, LocalDate collectionDate, LocalDate expirationDate, String bagStatus, String testResult, String freezerNumber, String batchCode, String complianceStatus, String notes, LocalDateTime processingDate) {
        this.donation = donation;
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


    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
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
