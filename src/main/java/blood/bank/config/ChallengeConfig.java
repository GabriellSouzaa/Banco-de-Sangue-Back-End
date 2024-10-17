package blood.bank.config;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.application.usecases.challenge.ListChallenge;
import blood.bank.infra.gateways.ChallengeRepositoryJpa;
import blood.bank.infra.mappers.ChallengeEntityMapper;
import blood.bank.infra.persistence.repositories.ChallengeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChallengeConfig {

    @Bean
    ChallengeEntityMapper challengeEntityMapper(){
        return new ChallengeEntityMapper();
    }

    @Bean
    ListChallenge listChallenge(ChallengeRepositoryGateway challengeRepositoryGateway) {
        return new ListChallenge(challengeRepositoryGateway);
    }

    @Bean
    ChallengeRepositoryJpa challengeRepositoryJpa(ChallengeRepository challengeRepository, ChallengeEntityMapper challengeEntityMapper) {
        return new ChallengeRepositoryJpa(challengeRepository, challengeEntityMapper);
    }
}

