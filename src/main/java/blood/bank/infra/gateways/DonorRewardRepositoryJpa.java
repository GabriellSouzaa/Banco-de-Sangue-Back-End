package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.infra.mappers.DonorRewardEntityMapper;
import blood.bank.infra.persistence.models.DonorRewardEntity;
import blood.bank.infra.persistence.repositories.DonorRewardRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonorRewardRepositoryJpa implements DonorRewardRepositoryGateway {

    private final DonorRewardRepository donorRewardRepository;

    private final DonorRewardEntityMapper donorRewardEntityMapper;

    public DonorRewardRepositoryJpa(DonorRewardRepository donorRewardRepository, DonorRewardEntityMapper donorRewardEntityMapper) {
        this.donorRewardRepository = donorRewardRepository;
        this.donorRewardEntityMapper = donorRewardEntityMapper;
    }

    @Override
    public List<DonorReward> getDonorsRewardByDonorId(Long donorId) {
        List<DonorRewardEntity> donorRewardEntities = this.donorRewardRepository.findAllByDonor_Id(donorId);
        return donorRewardEntities.stream().map(DonorRewardEntityMapper::toDonorReward).collect(Collectors.toList());
    }
}
