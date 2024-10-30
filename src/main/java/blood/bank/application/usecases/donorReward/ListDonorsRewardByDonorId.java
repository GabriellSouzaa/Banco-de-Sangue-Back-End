package blood.bank.application.usecases.donorReward;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.domain.entities.donorReward.DonorReward;

import java.util.List;

public class ListDonorsRewardByDonorId {

    private final DonorRewardRepositoryGateway donorRewardRepositoryGateway;

    public ListDonorsRewardByDonorId(DonorRewardRepositoryGateway donorRewardRepositoryGateway) {
        this.donorRewardRepositoryGateway = donorRewardRepositoryGateway;
    }

    public List<DonorReward> getDonorsRewardByDonorId(Long donorId) {
        return donorRewardRepositoryGateway.getDonorsRewardByDonorId(donorId);
    }
}
