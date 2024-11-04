package blood.bank.application.usecases.challenge;

import blood.bank.application.gateways.ChallengeRepositoryGateway;

public class DeleteChallenge {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    public DeleteChallenge(ChallengeRepositoryGateway challengeRepositoryGateway) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
    }

    public void deleteChallenge(Long challengeId){
        challengeRepositoryGateway.deleteChallenge(challengeId);
    }
}
