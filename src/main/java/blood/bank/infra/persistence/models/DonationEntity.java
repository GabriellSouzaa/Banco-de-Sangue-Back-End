package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "doacao")
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_doacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private DonorEntity donor;

    private String bloodType;

    private LocalDate registrationDate;

    private LocalDate lastDonationDate;

    private Integer donationCount;

    private Boolean eligibility;

    private String medicalNotes;

    private Integer bcoinsBalance;

    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    private BadgeEntity badge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
        this.donor = donor;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }

    public Integer getDonationCount() {
        return donationCount;
    }

    public void setDonationCount(Integer donationCount) {
        this.donationCount = donationCount;
    }

    public Boolean getEligibility() {
        return eligibility;
    }

    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getBcoinsBalance() {
        return bcoinsBalance;
    }

    public void setBcoinsBalance(Integer bcoinsBalance) {
        this.bcoinsBalance = bcoinsBalance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BadgeEntity getBadge() {
        return badge;
    }

    public void setBadge(BadgeEntity badge) {
        this.badge = badge;
    }
}
