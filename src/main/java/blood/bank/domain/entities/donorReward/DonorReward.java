package blood.bank.domain.entities.donorReward;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.reward.Reward;

public class DonorReward {

    private Donor donor;

    private Reward reward;

    public DonorReward(Donor donor, Reward reward) {
        this.donor = donor;
        this.reward = reward;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}
