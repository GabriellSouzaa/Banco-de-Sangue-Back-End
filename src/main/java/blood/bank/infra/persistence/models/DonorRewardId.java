package blood.bank.infra.persistence.models;

import java.io.Serializable;

public class DonorRewardId implements Serializable {

    private Long donorId;

    private Long rewardId;

    public DonorRewardId() {

    }

    public DonorRewardId(Long donorId, Long rewardId) {
        this.donorId = donorId;
        this.rewardId = rewardId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }
}
