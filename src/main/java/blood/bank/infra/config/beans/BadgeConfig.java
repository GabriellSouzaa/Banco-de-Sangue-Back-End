package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.application.usecases.badge.CreateBadge;
import blood.bank.application.usecases.badge.DeleteBadge;
import blood.bank.application.usecases.badge.ListBadges;
import blood.bank.application.usecases.badge.UpdateBadge;
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

    @Bean
    CreateBadge createBadge(BadgeRepositoryGateway badgeRepositoryGateway){
        return new CreateBadge(badgeRepositoryGateway);
    }

    @Bean
    UpdateBadge updateBadge(BadgeRepositoryGateway badgeRepositoryGateway){
        return new UpdateBadge(badgeRepositoryGateway);
    }

    @Bean
    DeleteBadge deleteBadge(BadgeRepositoryGateway badgeRepositoryGateway){
        return new DeleteBadge(badgeRepositoryGateway);
    }
}
