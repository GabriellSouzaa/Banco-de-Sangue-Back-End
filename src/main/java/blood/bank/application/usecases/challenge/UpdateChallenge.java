package blood.bank.application.usecases.challenge;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.infra.models.requests.ChallengeRequest;

public class UpdateChallenge {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    public UpdateChallenge(ChallengeRepositoryGateway challengeRepositoryGateway) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
    }

    public void updateChallenge(Long challengeId, ChallengeRequest challengeRequest){
        challengeRepositoryGateway.updateChallenge(challengeId, challengeRequest);
    }
}
