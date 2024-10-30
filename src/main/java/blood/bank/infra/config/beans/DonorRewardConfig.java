package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorRewardRepositoryGateway;
import blood.bank.application.usecases.donorReward.ListDonorsRewardByDonorId;
import blood.bank.infra.gateways.DonorRewardRepositoryJpa;
import blood.bank.infra.mappers.DonorRewardEntityMapper;
import blood.bank.infra.persistence.repositories.DonorRewardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorRewardConfig {

    @Bean
    DonorRewardEntityMapper donorRewardEntityMapper(){
        return new DonorRewardEntityMapper();
    }

    @Bean
    DonorRewardRepositoryJpa donorRewardRepositoryJpa(DonorRewardRepository donorRewardRepository, DonorRewardEntityMapper donorRewardEntityMapper){
        return new DonorRewardRepositoryJpa(donorRewardRepository, donorRewardEntityMapper);
    }

    @Bean
    ListDonorsRewardByDonorId listDonorsRewardByDonorId(DonorRewardRepositoryGateway donorRewardRepositoryGateway){
        return new ListDonorsRewardByDonorId(donorRewardRepositoryGateway);
    }
}
