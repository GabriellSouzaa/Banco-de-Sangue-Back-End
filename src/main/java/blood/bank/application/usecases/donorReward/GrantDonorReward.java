package blood.bank.application.usecases.donorReward;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.infra.models.requests.GrantDonorRewardRequest;

public class GrantDonorReward {

    private final DonorRewardRepositoryGateway donorRewardRepositoryGateway;

    public GrantDonorReward(DonorRewardRepositoryGateway donorRewardRepositoryGateway) {
        this.donorRewardRepositoryGateway = donorRewardRepositoryGateway;
    }

    public void grantDonorReward(GrantDonorRewardRequest grantDonorRewardRequest) {
        this.donorRewardRepositoryGateway.grantDonorReward(grantDonorRewardRequest);
    }
}
