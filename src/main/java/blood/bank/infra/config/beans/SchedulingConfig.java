package blood.bank.infra.config.beans;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.application.usecases.scheduling.ListScheduling;
import blood.bank.infra.gateways.SchedulingRepositoryJpa;
import blood.bank.infra.mappers.SchedulingEntityMapper;
import blood.bank.infra.persistence.repositories.SchedulingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulingConfig {

    @Bean
    SchedulingEntityMapper schedulingEntityMapper() {
        return new SchedulingEntityMapper();
    }

    @Bean
    SchedulingRepositoryJpa schedulingRepositoryJpa(SchedulingEntityMapper schedulingEntityMapper, SchedulingRepository schedulingRepository) {
        return new SchedulingRepositoryJpa(schedulingRepository, schedulingEntityMapper);
    }

    @Bean
    ListScheduling listScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new ListScheduling(schedulingRepositoryGateway);
    }
}
