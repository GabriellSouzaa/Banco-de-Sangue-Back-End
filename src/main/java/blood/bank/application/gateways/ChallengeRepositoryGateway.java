package blood.bank.application.gateways;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;

import java.util.List;

public interface ChallengeRepositoryGateway {

    List<Challenge> getChallenges();
}
