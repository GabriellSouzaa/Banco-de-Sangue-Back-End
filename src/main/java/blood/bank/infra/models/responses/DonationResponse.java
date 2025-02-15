package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donation.Donation;
import blood.bank.domain.entities.donor.Donor;

import java.time.LocalDate;

public class DonationResponse {

    private Long id;

    private Donor donor;

    private LocalDate dateDonation;

    private String donatioType;

    private Integer quantityCollected;

    private String donationStatus;

    private String observation;

    private Integer donationScore;

    public DonationResponse(Donation donation) {
        this.id = donation.getId();
        this.donor = donation.getDonor();
        this.dateDonation = donation.getDateDonation();
        this.donatioType = donation.getDonatioType();
        this.quantityCollected = donation.getQuantityCollected();
        this.donationStatus = donation.getDonationStatus();
        this.observation = donation.getObservation();
        this.donationScore = donation.getDonationScore();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
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
