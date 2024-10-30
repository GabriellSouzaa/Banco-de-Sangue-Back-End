package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.infra.mappers.DonorRewardEntityMapper;
import blood.bank.infra.models.requests.GrantDonorRewardRequest;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.DonorRewardEntity;
import blood.bank.infra.persistence.models.DonorRewardId;
import blood.bank.infra.persistence.models.RewardEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.DonorRewardRepository;
import blood.bank.infra.persistence.repositories.RewardRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonorRewardRepositoryJpa implements DonorRewardRepositoryGateway {

    private final DonorRewardRepository donorRewardRepository;

    private final DonorRewardEntityMapper donorRewardEntityMapper;

    private final DonorRepository donorRepository;

    private final RewardRepository rewardRepository;

    public DonorRewardRepositoryJpa(DonorRewardRepository donorRewardRepository, DonorRewardEntityMapper donorRewardEntityMapper, DonorRepository donorRepository, RewardRepository rewardRepository) {
        this.donorRewardRepository = donorRewardRepository;
        this.donorRewardEntityMapper = donorRewardEntityMapper;
        this.donorRepository = donorRepository;
        this.rewardRepository = rewardRepository;
    }

    @Override
    public List<DonorReward> getDonorsRewardByDonorId(Long donorId) {
        List<DonorRewardEntity> donorRewardEntities = this.donorRewardRepository.findAllByDonor_Id(donorId);
        return donorRewardEntities.stream().map(DonorRewardEntityMapper::toDonorReward).collect(Collectors.toList());
    }

    @Override
    public void grantDonorReward(GrantDonorRewardRequest grantDonorRewardRequest) {
        DonorRewardEntity donorRewardEntity = new DonorRewardEntity();

        DonorEntity donor = donorRepository.findById(grantDonorRewardRequest.getDonorId())
                .orElseThrow(() -> new IllegalArgumentException("Doador não encontrado"));

        RewardEntity reward = rewardRepository.findById(grantDonorRewardRequest.getRewardId())
                .orElseThrow(() -> new IllegalArgumentException("Recompensa não encontrada"));

        DonorRewardId donorRewardId = new DonorRewardId(donor.getId(), reward.getId());

        donorRewardEntity.setId(donorRewardId);
        donorRewardEntity.setDonor(donor);
        donorRewardEntity.setReward(reward);


        donorRewardRepository.save(donorRewardEntity);
    }
}
