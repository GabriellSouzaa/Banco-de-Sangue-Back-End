package blood.bank.application.usecases.reward;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.domain.entities.reward.Reward;

import java.util.List;

public class ListReward {

    private final RewardRepositoryGateway rewardRepositoryGateway;

    public ListReward(RewardRepositoryGateway rewardRepositoryGateway) {
        this.rewardRepositoryGateway = rewardRepositoryGateway;
    }

    public List<Reward> getAllRewards() {
        return rewardRepositoryGateway.getRewards();
    }
}
