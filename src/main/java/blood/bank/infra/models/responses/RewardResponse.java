package blood.bank.infra.models.responses;

import blood.bank.domain.entities.reward.Reward;

public class RewardResponse {

    private Long id;

    private String rewardName;

    private String rewardDescription;

    private String rewardType;

    private String valueInPoints;

    public RewardResponse(Reward reward){
        this.id = reward.getId();
        this.rewardName = reward.getRewardName();
        this.rewardDescription = reward.getRewardDescription();
        this.rewardType = reward.getRewardType();
        this.valueInPoints = reward.getValueInPoints();
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
