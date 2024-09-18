package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bolsa_de_sangue")
public class BloodBagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bolsa_de_sangue")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DonationEntity> donations;

    private String bloodType;

    private String bloodComponent;

    private String bagVolume;

    private LocalDate collectionDate;

    private LocalDate expirationDate;

    private String bagStatus;

    private String testResult;

    private String freezerNumber;

    private String batchCode;

    private String complianceStatus;

    private String notes;

    private LocalDateTime processingDate;

}
