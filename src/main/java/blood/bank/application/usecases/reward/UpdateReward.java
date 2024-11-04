package blood.bank.application.usecases.reward;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.infra.models.requests.RewardRequest;

public class UpdateReward {

    private final RewardRepositoryGateway rewardRepositoryGateway;

    public UpdateReward(RewardRepositoryGateway rewardRepositoryGateway){
        this.rewardRepositoryGateway = rewardRepositoryGateway;
    }

    public void updateReward(Long rewardId, RewardRequest rewardRequest){
        rewardRepositoryGateway.updateReward(rewardId, rewardRequest);
    }
}
