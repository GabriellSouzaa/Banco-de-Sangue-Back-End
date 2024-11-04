package blood.bank.infra.gateways;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.mappers.RewardEntityMapper;
import blood.bank.infra.models.requests.RewardRequest;
import blood.bank.infra.persistence.models.RewardEntity;
import blood.bank.infra.persistence.repositories.RewardRepository;
import jakarta.persistence.EntityNotFoundException;

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

    @Override
    public void createReward(RewardRequest rewardRequest) {
        RewardEntity rewardEntity = new RewardEntity();
        rewardEntity.setRewardName(rewardRequest.getRewardName());
        rewardEntity.setRewardDescription(rewardRequest.getRewardDescription());
        rewardEntity.setRewardType(rewardRequest.getRewardType());
        rewardEntity.setValueInPoints(rewardRequest.getValueInPoints());
        rewardRepository.save(rewardEntity);
    }

    @Override
    public void updateReward(Long rewardId, RewardRequest rewardRequest) {
        RewardEntity rewardEntity = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new EntityNotFoundException("Recompensa não encontrada"));

        rewardEntity.setRewardName(rewardRequest.getRewardName());
        rewardEntity.setRewardDescription(rewardRequest.getRewardDescription());
        rewardEntity.setRewardType(rewardRequest.getRewardType());
        rewardEntity.setValueInPoints(rewardRequest.getValueInPoints());

        this.rewardRepository.save(rewardEntity);
    }

    @Override
    public void deleteReward(Long rewardId) {
        RewardEntity rewardEntity = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new EntityNotFoundException("Recompensa não encontrada"));
        rewardRepository.delete(rewardEntity);

    }
}
