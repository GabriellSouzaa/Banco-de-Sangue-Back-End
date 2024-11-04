package blood.bank.application.usecases.reward;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.infra.models.requests.RewardRequest;

public class CreateReward {

    private final RewardRepositoryGateway rewardRepositoryGateway;

    public CreateReward(RewardRepositoryGateway rewardRepositoryGateway){
        this.rewardRepositoryGateway = rewardRepositoryGateway;
    }

    public void createReward(RewardRequest rewardRequest){
        rewardRepositoryGateway.createReward(rewardRequest);
    }
}
