package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.application.usecases.badge.ListBadges;
import blood.bank.infra.gateways.BadgeRepositoryJpa;
import blood.bank.infra.mappers.BadgeEntityMapper;
import blood.bank.infra.persistence.repositories.BadgeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BadgeConfig {

    @Bean
    BadgeEntityMapper badgeEntityMapper(){
        return new BadgeEntityMapper();
    }

    @Bean
    BadgeRepositoryJpa badgeRepositoryJpa(BadgeRepository badgeRepository, BadgeEntityMapper badgeEntityMapper) {
        return new BadgeRepositoryJpa(badgeRepository, badgeEntityMapper);
    }

    @Bean
    ListBadges listBadges(BadgeRepositoryGateway badgeRepositoryGateway){
        return new ListBadges(badgeRepositoryGateway);
    }
}
