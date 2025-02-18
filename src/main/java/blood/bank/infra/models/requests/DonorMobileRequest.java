package blood.bank.infra.models.requests;

import java.time.LocalDate;

public class DonorMobileRequest {

    private PeopleRequest people;

    private String bloodType;

    private LocalDate registerDate;

    private LocalDate lastDonationDate;

    private Long numberOfDonations;

    private Boolean eligibility;

    private String medicalNotes;

    private Long bCoinsBalance;

    private String image;

    public PeopleRequest getPeople() {
        return people;
    }

    public void setPeople(PeopleRequest people) {
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
}
