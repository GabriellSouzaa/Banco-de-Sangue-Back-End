package blood.bank.application.gateways;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.models.requests.ChallengeRequest;

import java.util.List;

public interface ChallengeRepositoryGateway {

    List<Challenge> getChallenges();

    void createChallenge(ChallengeRequest challengeRequest);

    void updateChallenge(Long challengeId, ChallengeRequest challengeRequest);

    void deleteChallenge(Long challengeId);

    Long countDonorChallenges(Long donorId);
}
