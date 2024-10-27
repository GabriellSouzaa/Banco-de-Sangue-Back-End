package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorChallengeRepositoryGateway;
import blood.bank.application.usecases.donorChallenge.ListDonorChallengeByDonorNameAndEmail;
import blood.bank.infra.gateways.DonorChallengeRepositoryJpa;
import blood.bank.infra.mappers.DonorChallengeEntityMapper;
import blood.bank.infra.persistence.repositories.DonorChallengeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorChallengeConfig {

    @Bean
    DonorChallengeEntityMapper donorChallengeEntityMapper() {
        return new DonorChallengeEntityMapper();
    }

    @Bean
    DonorChallengeRepositoryJpa donorChallengeRepositoryJpa(DonorChallengeRepository donorChallengeRepository, DonorChallengeEntityMapper donorChallengeEntityMapper) {
        return new DonorChallengeRepositoryJpa(donorChallengeRepository, donorChallengeEntityMapper);
    }

    @Bean
    ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorId(DonorChallengeRepositoryGateway donorChallengeRepositoryGateway){
        return new ListDonorChallengeByDonorNameAndEmail(donorChallengeRepositoryGateway);
    }
}
