package blood.bank.infra.models.requests;

import java.time.LocalDate;

public class DonationRequest {

    private DonorRequest donor;

    private LocalDate dateDonation;

    private String donatioType;

    private Integer quantityCollected;

    private String donationStatus;

    private String observation;

    private Integer donationScore;

    public DonorRequest getDonor() {
        return donor;
    }

    public void setDonor(DonorRequest donor) {
        this.donor = donor;
    }

    public LocalDate getDateDonation() {
        return dateDonation;
    }

    public void setDateDonation(LocalDate dateDonation) {
        this.dateDonation = dateDonation;
    }

    public String getDonatioType() {
        return donatioType;
    }

    public void setDonatioType(String donatioType) {
        this.donatioType = donatioType;
    }

    public Integer getQuantityCollected() {
        return quantityCollected;
    }

    public void setQuantityCollected(Integer quantityCollected) {
        this.quantityCollected = quantityCollected;
    }

    public String getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(String donationStatus) {
        this.donationStatus = donationStatus;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getDonationScore() {
        return donationScore;
    }

    public void setDonationScore(Integer donationScore) {
        this.donationScore = donationScore;
    }
}
