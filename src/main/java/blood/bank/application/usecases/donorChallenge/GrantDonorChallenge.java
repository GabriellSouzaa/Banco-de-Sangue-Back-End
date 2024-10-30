package blood.bank.application.usecases.donorChallenge;

import blood.bank.application.gateways.DonorChallengeRepositoryGateway;
import blood.bank.infra.models.requests.GrantDonorChallengeRequest;

public class GrantDonorChallenge {

    private final DonorChallengeRepositoryGateway donorChallengeRepositoryGateway;

    public GrantDonorChallenge(DonorChallengeRepositoryGateway donorChallengeRepositoryGateway) {
        this.donorChallengeRepositoryGateway = donorChallengeRepositoryGateway;
    }

    public void grantDonorChallenge(GrantDonorChallengeRequest grantDonorChallengeRequest) {
        this.donorChallengeRepositoryGateway.grantDonorChallenge(grantDonorChallengeRequest);
    }
}
