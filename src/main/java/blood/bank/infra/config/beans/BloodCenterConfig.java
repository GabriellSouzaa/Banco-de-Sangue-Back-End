package blood.bank.infra.config.beans;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.application.usecases.bloodCenter.CreateBloodCenter;
import blood.bank.application.usecases.bloodCenter.DeleteBloodCenter;
import blood.bank.application.usecases.bloodCenter.ListBloodCenter;
import blood.bank.application.usecases.bloodCenter.UpdateBloodCenter;
import blood.bank.infra.gateways.BloodCenterRepositoryJpa;
import blood.bank.infra.persistence.repositories.BloodCenterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BloodCenterConfig {

    @Bean
    BloodCenterRepositoryJpa bloodCenterRepositoryJpa(BloodCenterRepository repository, JdbcTemplate jdbcTemplate) {
        return new BloodCenterRepositoryJpa(repository, jdbcTemplate);
    }

    @Bean
    ListBloodCenter listBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        return new ListBloodCenter(bloodCenterRepositoryGateway);
    }

    @Bean
    CreateBloodCenter createBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        return new CreateBloodCenter(bloodCenterRepositoryGateway);
    }

    @Bean
    DeleteBloodCenter deleteBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        return new DeleteBloodCenter(bloodCenterRepositoryGateway);
    }

    @Bean
    UpdateBloodCenter updateBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        return new UpdateBloodCenter(bloodCenterRepositoryGateway);
    }
}
