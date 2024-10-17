package blood.bank.infra.mappers;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.persistence.models.ChallengeEntity;
import blood.bank.infra.persistence.models.RewardEntity;

public class ChallengeEntityMapper {

    public static ChallengeEntity toEntity(Challenge challenge) {
        RewardEntity rewardEntity = RewardEntityMapper.toEntity(challenge.getReward());
        return new ChallengeEntity(rewardEntity, challenge.getChallengeName(), challenge.getDescription(), challenge.getCriteria(), challenge.getStartDate(), challenge.getEndDate());
    }

    public static Challenge toChallenge(ChallengeEntity challengeEntity) {
        Reward reward = RewardEntityMapper.toReward(challengeEntity.getReward());
        return new Challenge(reward, challengeEntity.getChallengeName(), challengeEntity.getDescription(), challengeEntity.getCriteria(), challengeEntity.getStartDate(), challengeEntity.getEndDate());
    }
}
