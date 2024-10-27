package blood.bank.application.usecases.donorChallenge;

import blood.bank.application.gateways.DonorChallengeRepositoryGateway;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;

import java.util.List;

public class ListDonorChallengeByDonorNameAndEmail {

    private final DonorChallengeRepositoryGateway donorChallengeRepositoryGateway;

    public ListDonorChallengeByDonorNameAndEmail(DonorChallengeRepositoryGateway donorChallengeRepositoryGateway) {
        this.donorChallengeRepositoryGateway = donorChallengeRepositoryGateway;
    }

    public List<DonorChallenge> getDonorChallengeByDonorId(String donorName, String email) {
        return donorChallengeRepositoryGateway.getDonorChallengeByDonorFullNameAndEmail(donorName, email);
    }
}
