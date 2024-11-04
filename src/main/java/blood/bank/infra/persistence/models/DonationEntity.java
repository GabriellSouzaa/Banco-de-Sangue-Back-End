package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "doacao")
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doacao_id_seq")
    @SequenceGenerator(name = "doacao_id_seq", sequenceName = "doacao_id_seq", allocationSize = 1)
    @Column(name = "id_doacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doador_id_doador")
    private DonorEntity donor;

    @Column(name = "data_doacao")
    private LocalDate dateDonation;

    @Column(name = "tipo_doacao")
    private String donatioType;

    @Column(name = "quantidade_coletada")
    private Integer quantityCollected;

    @Column(name = "status_doacao")
    private String donationStatus;

    @Column(name = "observacao")
    private String observation;

    @Column(name = "pontuacao_da_doacao")
    private Integer donationScore;

    public DonationEntity() {
    }

    public DonationEntity(DonorEntity donor, LocalDate dateDonation, String donatioType, Integer quantityCollected, String donationStatus, String observation, Integer donationScore) {
        this.donor = donor;
        this.dateDonation = dateDonation;
        this.donatioType = donatioType;
        this.quantityCollected = quantityCollected;
        this.donationStatus = donationStatus;
        this.observation = observation;
        this.donationScore = donationScore;
    }

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
