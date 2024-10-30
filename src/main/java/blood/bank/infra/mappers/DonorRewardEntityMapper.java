package blood.bank.infra.mappers;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.DonorRewardEntity;
import blood.bank.infra.persistence.models.RewardEntity;

public class DonorRewardEntityMapper {

    public static DonorRewardEntity toEntity(DonorReward donorReward){
        DonorEntity donorEntity = new DonorEntity();
        RewardEntity rewardEntity = new RewardEntity();
        return new DonorRewardEntity(donorEntity, rewardEntity);
    }

    public static DonorReward toDonorReward(DonorRewardEntity donorRewardEntity){
        Donor donor = DonorMapper.toDonor(donorRewardEntity.getDonor());
        Reward reward = RewardEntityMapper.toReward(donorRewardEntity.getReward());
        return new DonorReward(donor, reward);
    }
}
