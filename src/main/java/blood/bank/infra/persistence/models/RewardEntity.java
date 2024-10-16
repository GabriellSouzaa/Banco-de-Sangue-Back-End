package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


@Entity
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
