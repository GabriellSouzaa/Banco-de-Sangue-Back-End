package blood.bank.infra.config.beans;

import blood.bank.application.gateways.ApplicantRepositoryGateway;
import blood.bank.application.usecases.applicant.ListApplicant;
import blood.bank.infra.gateways.ApplicantRepositoryJpa;
import blood.bank.infra.mappers.ApplicantMapper;
import blood.bank.infra.persistence.repositories.ApplicantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicantConfig {

    @Bean
    ApplicantMapper applicantMapper() {
        return new ApplicantMapper();
    }

    @Bean
    ApplicantRepositoryJpa applicantRepositoryJpa(ApplicantRepository applicantRepository) {
        return new ApplicantRepositoryJpa(applicantRepository);
    }

    @Bean
    ListApplicant listApplicant(ApplicantRepositoryGateway applicantRepositoryGateway) {
        return new ListApplicant(applicantRepositoryGateway);
    }
}
