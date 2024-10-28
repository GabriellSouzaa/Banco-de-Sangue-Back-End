package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donorChallenge.DonorChallenge;

public class DonorChallengeResponse {

    private DonorResponse donor;

    private ChallengeResponse challenge;

    public DonorChallengeResponse(DonorChallenge donorChallenge){
        this.donor = new DonorResponse(donorChallenge.getDonor());
        this.challenge = new ChallengeResponse(donorChallenge.getChallenge());
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
        this.donor = donor;
    }

    public ChallengeResponse getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeResponse challenge) {
        this.challenge = challenge;
    }
}
