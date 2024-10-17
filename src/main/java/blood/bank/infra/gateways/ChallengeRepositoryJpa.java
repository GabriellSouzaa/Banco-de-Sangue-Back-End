package blood.bank.infra.gateways;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.mappers.ChallengeEntityMapper;
import blood.bank.infra.persistence.models.ChallengeEntity;
import blood.bank.infra.persistence.models.RewardEntity;
import blood.bank.infra.persistence.repositories.ChallengeRepository;

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
}
