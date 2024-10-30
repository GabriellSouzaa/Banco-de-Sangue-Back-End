package blood.bank.application.gateways;

import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.infra.models.requests.GrantDonorRewardRequest;

import java.util.List;

public interface DonorRewardRepositoryGateway {

    List<DonorReward> getDonorsRewardByDonorId(Long donorId);

    void grantDonorReward(GrantDonorRewardRequest grantDonorRewardRequest);
}
