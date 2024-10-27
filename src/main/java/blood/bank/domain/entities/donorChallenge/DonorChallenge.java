package blood.bank.domain.entities.donorChallenge;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.donor.Donor;

public class DonorChallenge {

    private Donor donor;

    private Challenge challenge;

    public DonorChallenge(Donor donor, Challenge challenge) {
        this.donor = donor;
        this.challenge = challenge;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
