package blood.bank.infra.config.beans;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.application.usecases.reward.ListReward;
import blood.bank.infra.gateways.RewardRepositoryJpa;
import blood.bank.infra.mappers.RewardEntityMapper;
import blood.bank.infra.persistence.repositories.RewardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RewardConfig {

    @Bean
    RewardEntityMapper rewardEntityMapper(){
        return new RewardEntityMapper();
    }

    @Bean
    RewardRepositoryJpa rewardRepositoryJpa(RewardRepository rewardRepository, RewardEntityMapper rewardEntityMapper){
        return new RewardRepositoryJpa(rewardRepository, rewardEntityMapper);
    }

    @Bean
    ListReward listReward(RewardRepositoryGateway rewardRepositoryGateway){
        return new ListReward(rewardRepositoryGateway);
    }
}
