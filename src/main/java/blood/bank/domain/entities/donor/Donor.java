package blood.bank.domain.entities.donor;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.people.People;

import java.time.LocalDate;
import java.util.List;

public class Donor {

    private Long id;

    private People people;

    private String bloodType;

    private LocalDate registerDate;

    private LocalDate lastDonationDate;

    private Long numberOfDonations;

    private Boolean eligibility;

    private String medicalNotes;

    private Long bCoinsBalance;

    private String image;

    private List<Badge> badge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public Long getNumberOfDonations() {
        return numberOfDonations;
    }

    public void setNumberOfDonations(Long numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
    }

    public Boolean getEligibility() {
        return eligibility;
    }

    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }

    public Long getbCoinsBalance() {
        return bCoinsBalance;
    }

    public void setbCoinsBalance(Long bCoinsBalance) {
        this.bCoinsBalance = bCoinsBalance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Badge> getBadge() {
        return badge;
    }

    public void setBadge(List<Badge> badge) {
        this.badge = badge;
    }

    public Donor(Long id, People people, String bloodType, LocalDate registerDate, LocalDate lastDonationDate, Long numberOfDonations, Boolean eligibility, String medicalNotes, Long bCoinsBalance, String image, List<Badge> badge) {
        this.id = id;
        this.people = people;
        this.bloodType = bloodType;
        this.registerDate = registerDate;
        this.lastDonationDate = lastDonationDate;
        this.numberOfDonations = numberOfDonations;
        this.eligibility = eligibility;
        this.medicalNotes = medicalNotes;
        this.bCoinsBalance = bCoinsBalance;
        this.image = image;
        this.badge = badge;
    }
}
