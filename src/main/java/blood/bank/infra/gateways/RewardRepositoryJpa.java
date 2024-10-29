package blood.bank.infra.gateways;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.mappers.RewardEntityMapper;
import blood.bank.infra.persistence.models.RewardEntity;
import blood.bank.infra.persistence.repositories.RewardRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RewardRepositoryJpa implements RewardRepositoryGateway {

    private final RewardRepository rewardRepository;

    private final RewardEntityMapper rewardEntityMapper;

    public RewardRepositoryJpa(RewardRepository rewardRepository, RewardEntityMapper rewardEntityMapper){
        this.rewardRepository = rewardRepository;
        this.rewardEntityMapper = rewardEntityMapper;
    }

    @Override
    public List<Reward> getRewards() {
        List<RewardEntity> rewardEntities = rewardRepository.findAll();
        return rewardEntities.stream().map(RewardEntityMapper::toReward).collect(Collectors.toList());
    }
}
