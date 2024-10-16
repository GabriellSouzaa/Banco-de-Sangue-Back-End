package blood.bank.domain.entities.donation;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.donor.Donor;

import java.time.LocalDate;

public class Donation {

    private Donor donor;

    private String bloodType;

    private LocalDate registrationDate;

    private LocalDate lastDonationDate;

    private Integer donationCount;

    private Boolean eligibility;

    private String medicalNotes;

    private Integer bcoinsBalance;

    private String image;

    private Badge badge;
}
