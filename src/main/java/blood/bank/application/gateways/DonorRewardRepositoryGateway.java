package blood.bank.application.gateways;

import blood.bank.domain.entities.donorReward.DonorReward;

import java.util.List;

public interface DonorRewardRepositoryGateway {

    List<DonorReward> getDonorsRewardByDonorId(Long donorId);
}
