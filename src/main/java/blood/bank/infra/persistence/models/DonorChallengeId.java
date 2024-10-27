package blood.bank.infra.persistence.models;

import java.io.Serializable;

public class DonorChallengeId implements Serializable {

    private Long donorId;

    private Long challengeId;

    public DonorChallengeId() {

    }


    public DonorChallengeId(Long donorId, Long challengeId) {
        this.donorId = donorId;
        this.challengeId = challengeId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }
}
