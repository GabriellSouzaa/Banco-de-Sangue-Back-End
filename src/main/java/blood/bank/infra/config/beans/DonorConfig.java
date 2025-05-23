package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.application.usecases.donor.*;
import blood.bank.infra.gateways.DonorRepositoryJpa;
import blood.bank.infra.persistence.repositories.DonorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorConfig {

    @Bean
    GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors(DonorRepositoryGateway donorRepository) {
        return new GenerateReportOnActiveAndInactiveDonors(donorRepository);
    }

    @Bean
    DonorRepositoryJpa donorRepositoryJpa(DonorRepository donorRepository) {
        return new DonorRepositoryJpa(donorRepository);
    }

    @Bean
    ListDonor listDonor (DonorRepositoryGateway donorRepositoryGateway) {
        return new ListDonor(donorRepositoryGateway);
    }

    @Bean
    AwardPoints awardPoints (DonorRepositoryGateway donorRepositoryGateway) {
        return new AwardPoints(donorRepositoryGateway);
    }

    @Bean
    GetAvaibleDonors getAvaibleDonors(DonorRepositoryGateway donorRepositoryGateway) {
        return new GetAvaibleDonors(donorRepositoryGateway);
    }

    @Bean
    CreateDonor createDonor(DonorRepositoryGateway donorRepositoryGateway) {
        return new CreateDonor(donorRepositoryGateway);
    }

    @Bean
    UpdateDonor updateDonor(DonorRepositoryGateway donorRepositoryGateway) {
        return new UpdateDonor(donorRepositoryGateway);
    }

    @Bean
    DeleteDonor deleteDonor(DonorRepositoryGateway donorRepositoryGateway){
        return new DeleteDonor(donorRepositoryGateway);
    }

    @Bean
    CreateDonorMobile createDonorMobile(DonorRepositoryGateway donorRepositoryGateway) {
        return new CreateDonorMobile(donorRepositoryGateway);
    }
}
