package blood.bank.infra.config.beans;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.application.usecases.scheduling.*;
import blood.bank.infra.gateways.SchedulingRepositoryJpa;
import blood.bank.infra.mappers.SchedulingEntityMapper;
import blood.bank.infra.persistence.repositories.DonorRepository;
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
    SchedulingRepositoryJpa schedulingRepositoryJpa(SchedulingEntityMapper schedulingEntityMapper, SchedulingRepository schedulingRepository, DonorRepository donorRepository) {
        return new SchedulingRepositoryJpa(schedulingRepository, schedulingEntityMapper, donorRepository);
    }

    @Bean
    ListScheduling listScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new ListScheduling(schedulingRepositoryGateway);
    }

    @Bean
    GenerateReportSchedulingMonth generateReportSchedulingMonth(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new GenerateReportSchedulingMonth(schedulingRepositoryGateway);
    }

    @Bean
    GenerateReportSchedulingCanceled generateReportSchedulingCanceled(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new GenerateReportSchedulingCanceled(schedulingRepositoryGateway);
    }

    @Bean
    CreateScheduling createScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new CreateScheduling(schedulingRepositoryGateway);
    }

    @Bean
    DeleteSchedulingById deleteSchedulingById(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new DeleteSchedulingById(schedulingRepositoryGateway);
    }

    @Bean
    UpdateScheduling updateScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        return new UpdateScheduling(schedulingRepositoryGateway);
    }
}
