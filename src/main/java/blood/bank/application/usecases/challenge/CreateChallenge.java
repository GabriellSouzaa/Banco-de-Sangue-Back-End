package blood.bank.application.usecases.challenge;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.infra.models.requests.ChallengeRequest;

public class CreateChallenge {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    public CreateChallenge(final ChallengeRepositoryGateway challengeRepositoryGateway) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
    }

    public void createChallenge(ChallengeRequest challengeRequest){
        this.challengeRepositoryGateway.createChallenge(challengeRequest);
    }
}
