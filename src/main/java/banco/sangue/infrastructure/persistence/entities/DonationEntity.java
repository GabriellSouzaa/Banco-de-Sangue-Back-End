package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "doacao")
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_doacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PeopleEntity people;

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
}
