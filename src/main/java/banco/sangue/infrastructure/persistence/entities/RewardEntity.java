package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recompensa")
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_recompensa")
    private Long id;

    private String rewardName;

    private String rewardDescription;

    private String rewardType;

    private String valueInPoints;

}
