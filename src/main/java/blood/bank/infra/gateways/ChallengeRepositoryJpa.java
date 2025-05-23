package blood.bank.infra.gateways;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.mappers.ChallengeEntityMapper;
import blood.bank.infra.models.requests.ChallengeRequest;
import blood.bank.infra.persistence.models.ChallengeEntity;
import blood.bank.infra.persistence.models.RewardEntity;
import blood.bank.infra.persistence.repositories.ChallengeRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class ChallengeRepositoryJpa implements ChallengeRepositoryGateway {

    private final ChallengeRepository challengeRepository;

    private final ChallengeEntityMapper challengeEntityMapper;

    public ChallengeRepositoryJpa(ChallengeRepository challengeRepository, ChallengeEntityMapper challengeEntityMapper) {
        this.challengeRepository = challengeRepository;
        this.challengeEntityMapper = challengeEntityMapper;
    }

    @Override
    public List<Challenge> getChallenges() {
        List<ChallengeEntity> challengeEntities = this.challengeRepository.findAll();
        return challengeEntities.stream().map(ChallengeEntityMapper::toChallenge).collect(Collectors.toList());
    }

    @Override
    public void createChallenge(ChallengeRequest challengeRequest) {
        ChallengeEntity challenge = new ChallengeEntity();
        RewardEntity reward = new RewardEntity();

        reward.setRewardName(challengeRequest.getReward().getRewardName());
        reward.setRewardDescription(challengeRequest.getReward().getRewardDescription());
        reward.setRewardType(challengeRequest.getReward().getRewardType());
        reward.setValueInPoints(challengeRequest.getReward().getValueInPoints());
        challenge.setReward(reward);
        challenge.setChallengeName(challengeRequest.getChallengeName());
        challenge.setDescription(challengeRequest.getDescription());
        challenge.setCriteria(challengeRequest.getCriteria());
        challenge.setStartDate(challengeRequest.getStartDate());
        challenge.setEndDate(challengeRequest.getEndDate());

        this.challengeRepository.save(challenge);
    }

    @Override
    public void updateChallenge(Long challengeId, ChallengeRequest challengeRequest) {
        ChallengeEntity challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new EntityNotFoundException("Desafio não encontrado"));

        RewardEntity reward = challenge.getReward();
        reward.setRewardName(challengeRequest.getReward().getRewardName());
        reward.setRewardDescription(challengeRequest.getReward().getRewardDescription());
        reward.setRewardType(challengeRequest.getReward().getRewardType());
        reward.setValueInPoints(challengeRequest.getReward().getValueInPoints());
        challenge.setReward(reward);
        challenge.setChallengeName(challengeRequest.getChallengeName());
        challenge.setDescription(challengeRequest.getDescription());
        challenge.setCriteria(challengeRequest.getCriteria());
        challenge.setStartDate(challengeRequest.getStartDate());
        challenge.setEndDate(challengeRequest.getEndDate());

        this.challengeRepository.save(challenge);
    }

    @Override
    public void deleteChallenge(Long challengeId) {
        ChallengeEntity challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new EntityNotFoundException("Desafio não encontrado"));
        this.challengeRepository.delete(challenge);
    }

    @Override
    public Long countDonorChallenges(Long donorId) {
        return 0L;
    }
}
