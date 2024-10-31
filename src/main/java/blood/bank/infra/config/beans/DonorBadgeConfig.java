package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorBadgeRepositoryGateway;
import blood.bank.application.usecases.donorBadge.GrantDonorBadge;
import blood.bank.application.usecases.donorBadge.ListDonorBadgesByDonorId;
import blood.bank.infra.gateways.DonorBadgeRepositoryJpa;
import blood.bank.infra.mappers.DonorBadgeEntityMapper;
import blood.bank.infra.persistence.repositories.BadgeRepository;
import blood.bank.infra.persistence.repositories.DonorBadgeRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorBadgeConfig {

    @Bean
    DonorBadgeEntityMapper donorBadgeEntityMapper() {
        return new DonorBadgeEntityMapper();
    }

    @Bean
    DonorBadgeRepositoryJpa donorBadgeRepositoryJpa(DonorBadgeRepository donorBadgeRepository, DonorBadgeEntityMapper donorBadgeEntityMapper, DonorRepository donorRepository, BadgeRepository badgeRepository) {
        return new DonorBadgeRepositoryJpa(donorBadgeRepository, donorBadgeEntityMapper, donorRepository, badgeRepository);
    }

    @Bean
    ListDonorBadgesByDonorId listDonorBadgesByDonorId(DonorBadgeRepositoryGateway donorBadgeRepositoryGateway){
        return new ListDonorBadgesByDonorId(donorBadgeRepositoryGateway);
    }

    @Bean
    GrantDonorBadge grantDonorBadge(DonorBadgeRepositoryGateway donorBadgeRepositoryGateway){
        return new GrantDonorBadge(donorBadgeRepositoryGateway);
    }
}
