package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donorReward.DonorReward;

public class DonorRewardResponse {

    private DonorResponse donorResponse;

    private RewardResponse rewardResponse;

    public DonorRewardResponse(DonorReward donorReward) {
        this.donorResponse = new DonorResponse(donorReward.getDonor());
        this.rewardResponse = new RewardResponse(donorReward.getReward());
    }

    public DonorResponse getDonorResponse() {
        return donorResponse;
    }

    public void setDonorResponse(DonorResponse donorResponse) {
        this.donorResponse = donorResponse;
    }

    public RewardResponse getRewardResponse() {
        return rewardResponse;
    }

    public void setRewardResponse(RewardResponse rewardResponse) {
        this.rewardResponse = rewardResponse;
    }
}
