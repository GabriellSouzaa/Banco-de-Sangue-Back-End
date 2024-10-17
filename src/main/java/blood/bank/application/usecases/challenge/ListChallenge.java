package blood.bank.application.usecases.challenge;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.persistence.repositories.ChallengeRepository;

import java.util.List;

public class ListChallenge {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    public ListChallenge(ChallengeRepositoryGateway challengeRepositoryGateway) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
    }

    public List<Challenge> challenges(){
        return this.challengeRepositoryGateway.getChallenges();
    }
}
