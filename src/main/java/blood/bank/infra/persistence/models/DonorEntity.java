package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "doador")
public class DonorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_doador")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id_pessoa")
    private PeopleEntity people;

    @Column(name = "tipo_sanguineo")
    private String bloodType;

    @Column(name = "data_registro")
    private LocalDate registerDate;

    @Column(name = "data_ultima_doacao")
    private LocalDate lastDonationDate;

    @Column(name = "numero_doacoes")
    private Long numberOfDonations;

    @Column(name = "elegibilidade")
    private Boolean eligibility;

    @Column(name = "notas_medicas")
    private String medicalNotes;

    @Column(name = "saldo_bcoins")
    private Long bCoinsBalance;

    @Column(name = "imagem")
    private String image;

    public DonorEntity() {
    }

    public DonorEntity(Long id, PeopleEntity people, String bloodType, LocalDate registerDate, LocalDate lastDonationDate, Long numberOfDonations, Boolean eligibility, String medicalNotes, Long bCoinsBalance, String image) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
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

    public Long getNumberOfDonations() {
        return numberOfDonations;
    }

    public void setNumberOfDonations(Long numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
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

