package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "desafio")
public class ChallengeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_desafio")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private RewardEntity reward;


    private String challengeName;

    private String description;

    private String criteria;

    private LocalDate startDate;

    private LocalDate endDate;

}
