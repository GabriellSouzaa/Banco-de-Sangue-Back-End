package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


@Entity
@Table(name = "recompensa")
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_recompensa")
    private Long id;

    @Column(name = "nome_recompensa")
    private String rewardName;

    @Column(name = "descricao_recompensa")
    private String rewardDescription;

    @Column(name = "tipo_recompensa")
    private String rewardType;

    @Column(name = "valor_em_pontos")
    private String valueInPoints;

    public RewardEntity() {
    }

    public RewardEntity(Long id, String rewardName, String rewardDescription, String rewardType, String valueInPoints) {
        this.id = id;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardType = rewardType;
        this.valueInPoints = valueInPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getValueInPoints() {
        return valueInPoints;
    }

    public void setValueInPoints(String valueInPoints) {
        this.valueInPoints = valueInPoints;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }
}
