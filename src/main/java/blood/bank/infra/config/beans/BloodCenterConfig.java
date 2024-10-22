package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.application.usecases.bloodCenter.ListBloodCenter;
import blood.bank.infra.gateways.BloodCenterRepositoryJpa;
import blood.bank.infra.persistence.repositories.BloodCenterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BloodCenterConfig {

    @Bean
    BloodCenterRepositoryJpa bloodCenterRepositoryJpa(BloodCenterRepository repository) {
        return new BloodCenterRepositoryJpa(repository);
    }

    @Bean
    ListBloodCenter listBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        return new ListBloodCenter(bloodCenterRepositoryGateway);
    }
}
