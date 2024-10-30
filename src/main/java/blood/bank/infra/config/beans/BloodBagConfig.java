package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.application.usecases.bloodBag.DeleteExpiredBloodBags;
import blood.bank.application.usecases.bloodBag.ListBloodBag;
import blood.bank.infra.gateways.BloodBagRepositoryJpa;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.persistence.repositories.BloodBagRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BloodBagConfig {

    @Bean
    BloodBagEntityMapper bloodBagEntityMapper() {
        return new BloodBagEntityMapper();
    }

    @Bean
    BloodBagRepositoryJpa bloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, BloodBagEntityMapper bloodBagEntityMapper) {
        return new BloodBagRepositoryJpa(bloodBagRepository, bloodBagEntityMapper);
    }

    @Bean
    ListBloodBag listBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new ListBloodBag(bloodBagRepositoryGateway);
    }

    @Bean
    DeleteExpiredBloodBags deleteExpiredBloodBags(BloodBagRepositoryGateway bloodBagRepositoryGateway){
        return new DeleteExpiredBloodBags(bloodBagRepositoryGateway);
    }
}
