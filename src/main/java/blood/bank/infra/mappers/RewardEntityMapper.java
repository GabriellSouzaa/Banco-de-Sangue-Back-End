package blood.bank.infra.mappers;

import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.persistence.models.RewardEntity;

public class RewardEntityMapper {

    public static RewardEntity toEntity(Reward reward) {
        return new RewardEntity(reward.getId(), reward.getRewardName(), reward.getRewardDescription(), reward.getRewardType(), reward.getValueInPoints());
    }

    public static Reward toReward(RewardEntity rewardEntity) {
        return new Reward(rewardEntity.getId(), rewardEntity.getRewardName(), rewardEntity.getRewardDescription(), rewardEntity.getRewardType(), rewardEntity.getValueInPoints());
    }
}
