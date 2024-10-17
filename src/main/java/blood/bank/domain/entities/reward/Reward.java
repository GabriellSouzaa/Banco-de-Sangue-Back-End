package blood.bank.domain.entities.reward;

public class Reward {

    private String rewardName;

    private String rewardDescription;

    private String rewardType;

    private String valueInPoints;

    public Reward(String rewardName, String rewardDescription, String rewardType, String valueInPoints) {
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardType = rewardType;
        this.valueInPoints = valueInPoints;
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
