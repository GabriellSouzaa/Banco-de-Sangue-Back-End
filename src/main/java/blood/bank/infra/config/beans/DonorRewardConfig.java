package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.application.usecases.donorReward.GrantDonorReward;
import blood.bank.application.usecases.donorReward.ListDonorsRewardByDonorId;
import blood.bank.infra.gateways.DonorRewardRepositoryJpa;
import blood.bank.infra.mappers.DonorRewardEntityMapper;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.DonorRewardRepository;
import blood.bank.infra.persistence.repositories.RewardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorRewardConfig {

    @Bean
    DonorRewardEntityMapper donorRewardEntityMapper(){
        return new DonorRewardEntityMapper();
    }

    @Bean
    DonorRewardRepositoryJpa donorRewardRepositoryJpa(DonorRewardRepository donorRewardRepository, DonorRewardEntityMapper donorRewardEntityMapper, DonorRepository donorRepository, RewardRepository rewardRepository){
        return new DonorRewardRepositoryJpa(donorRewardRepository, donorRewardEntityMapper, donorRepository, rewardRepository);
    }

    @Bean
    ListDonorsRewardByDonorId listDonorsRewardByDonorId(DonorRewardRepositoryGateway donorRewardRepositoryGateway){
        return new ListDonorsRewardByDonorId(donorRewardRepositoryGateway);
    }

    @Bean
    GrantDonorReward grantDonorReward(DonorRewardRepositoryGateway donorRewardRepositoryGateway){
        return new GrantDonorReward(donorRewardRepositoryGateway);
    }
}
