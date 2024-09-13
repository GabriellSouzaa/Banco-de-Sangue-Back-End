package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "doador")
public class DonorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_doacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_insigna")
    private List<BadgeEntity> badge;
}

