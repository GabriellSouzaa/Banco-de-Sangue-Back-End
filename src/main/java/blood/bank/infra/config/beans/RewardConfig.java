package blood.bank.infra.config.beans;

import blood.bank.application.gateways.RewardRepositoryGateway;
import blood.bank.application.usecases.reward.CreateReward;
import blood.bank.application.usecases.reward.DeleteReward;
import blood.bank.application.usecases.reward.ListReward;
import blood.bank.application.usecases.reward.UpdateReward;
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

    @Bean
    CreateReward createReward(RewardRepositoryGateway rewardRepositoryGateway){
        return new CreateReward(rewardRepositoryGateway);
    }

    @Bean
    UpdateReward updateReward(RewardRepositoryGateway rewardRepositoryGateway){
        return new UpdateReward(rewardRepositoryGateway);
    }

    @Bean
    DeleteReward deleteReward(RewardRepositoryGateway rewardRepositoryGateway){
        return new DeleteReward(rewardRepositoryGateway);
    }
}
