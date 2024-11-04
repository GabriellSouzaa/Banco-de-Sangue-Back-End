package blood.bank.application.usecases.reward;

import blood.bank.application.gateways.RewardRepositoryGateway;

public class DeleteReward {

    private final RewardRepositoryGateway rewardRepositoryGateway;

    public DeleteReward(RewardRepositoryGateway rewardRepositoryGateway){
        this.rewardRepositoryGateway = rewardRepositoryGateway;
    }

    public void deleteReward(Long rewardId){
        rewardRepositoryGateway.deleteReward(rewardId);
    }
}
