package blood.bank.domain.entities.reward;

public class Reward {

    private Long id;

    private String rewardName;

    private String rewardDescription;

    private String rewardType;

    private String valueInPoints;

    public Reward(Long id, String rewardName, String rewardDescription, String rewardType, String valueInPoints) {
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

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
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
}
