package blood.bank.domain.entities.donation;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.donor.Donor;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class Donation {

    private Donor donor;

    private LocalDate dateDonation;

    private String donatioType;

    private Integer quantityCollected;

    private String donationStatus;

    private String observation;

    private Integer donationScore;

    public Donation(Donor donor, String donatioType, LocalDate dateDonation, Integer quantityCollected, String donationStatus, String observation, Integer donationScore) {
        this.donor = donor;
        this.donatioType = donatioType;
        this.dateDonation = dateDonation;
        this.quantityCollected = quantityCollected;
        this.donationStatus = donationStatus;
        this.observation = observation;
        this.donationScore = donationScore;
    }

    public Donor getDonor() {
        return donor;
    }

    public LocalDate getDateDonation() {
        return dateDonation;
    }

    public String getDonatioType() {
        return donatioType;
    }

    public Integer getQuantityCollected() {
        return quantityCollected;
    }

    public String getDonationStatus() {
        return donationStatus;
    }

    public String getObservation() {
        return observation;
    }

    public Integer getDonationScore() {
        return donationScore;
    }
}
