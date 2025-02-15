package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.application.usecases.bloodBag.*;
import blood.bank.application.usecases.bloodBag.DeleteExpiredBloodBags;
import blood.bank.application.usecases.bloodBag.GenerateReportBloodBag;
import blood.bank.application.usecases.bloodBag.ListBloodBag;
import blood.bank.infra.gateways.BloodBagRepositoryJpa;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.persistence.repositories.BloodBagRepository;
import blood.bank.infra.persistence.repositories.DonationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BloodBagConfig {

    @Bean
    BloodBagEntityMapper bloodBagEntityMapper() {
        return new BloodBagEntityMapper();
    }

    @Bean
    BloodBagRepositoryJpa bloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, JdbcTemplate jdbcTemplate, DonationRepository donationRepository) {
        return new BloodBagRepositoryJpa(bloodBagRepository, jdbcTemplate, donationRepository);
    }

    @Bean
    ListBloodBag listBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new ListBloodBag(bloodBagRepositoryGateway);
    }

    @Bean
    DeleteExpiredBloodBags deleteExpiredBloodBags(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new DeleteExpiredBloodBags(bloodBagRepositoryGateway);
    }

    @Bean
    CreateBloodBag createBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new CreateBloodBag(bloodBagRepositoryGateway);
    }

    @Bean
    UpdateBloodBag updateBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new UpdateBloodBag(bloodBagRepositoryGateway);
    }

    @Bean
    DeleteBloodBag deleteBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new DeleteBloodBag(bloodBagRepositoryGateway);
    }

    @Bean
    GenerateReportBloodBag generateReportBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new GenerateReportBloodBag(bloodBagRepositoryGateway);
    }
}
