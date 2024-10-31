package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donor.Donor;

import java.time.LocalDate;

public class DonorResponse {

    private Long id;

    private PeopleResponse people;

    private String bloodType;

    private LocalDate registerDate;

    private LocalDate lastDonationDate;

    private Long numberOfDonations;


    private Boolean eligibility;

    private String medicalNotes;

    private Long bCoinsBalance;

    private String image;

    public DonorResponse(Donor donor) {
        this.id = donor.getId();
        this.people = new PeopleResponse(donor.getPeople());
        this.bloodType = donor.getBloodType();
        this.registerDate = donor.getRegisterDate();
        this.lastDonationDate = donor.getLastDonationDate();
        this.numberOfDonations = donor.getNumberOfDonations();
        this.medicalNotes = donor.getMedicalNotes();
        this.eligibility = donor.getEligibility();
        this.bCoinsBalance = donor.getbCoinsBalance();
        this.image = donor.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeopleResponse getPeople() {
        return people;
    }

    public void setPeople(PeopleResponse people) {
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

    public Boolean getEligibility() {
        return eligibility;
    }

    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }

    public Long getNumberOfDonations() {
        return numberOfDonations;
    }

    public void setNumberOfDonations(Long numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
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
