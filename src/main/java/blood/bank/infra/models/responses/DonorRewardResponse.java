package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donorReward.DonorReward;

public class DonorRewardResponse {

    private DonorResponse donor;

    private RewardResponse reward;

    public DonorRewardResponse(DonorReward donorReward) {
        this.donor = new DonorResponse(donorReward.getDonor());
        this.reward = new RewardResponse(donorReward.getReward());
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
        this.donor = donor;
    }

    public RewardResponse getReward() {
        return reward;
    }

    public void setReward(RewardResponse reward) {
        this.reward = reward;
    }
}
