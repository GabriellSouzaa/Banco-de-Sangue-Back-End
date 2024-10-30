package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.persistence.models.BadgeEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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


    private List<BadgeResponse> badge;

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
        this.badge = donor.getBadge().stream().map(BadgeResponse::new).toList();
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

    public List<BadgeResponse> getBadge() {
        return badge;
    }

    public void setBadge(List<BadgeResponse> badge) {
        this.badge = badge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
