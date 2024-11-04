package blood.bank.application.gateways;

import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.models.requests.RewardRequest;

import java.util.List;

public interface RewardRepositoryGateway {

    List<Reward> getRewards();

    void createReward(RewardRequest rewardRequest);

    void updateReward(Long rewardId, RewardRequest rewardRequest);

    void deleteReward(Long rewardId);
}
