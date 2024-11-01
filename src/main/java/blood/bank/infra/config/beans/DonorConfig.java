package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.application.usecases.donor.AwardPoints;
import blood.bank.application.usecases.donor.GenerateReportOnActiveAndInactiveDonors;
import blood.bank.application.usecases.donor.GetAvaibleDonors;
import blood.bank.application.usecases.donor.ListDonor;
import blood.bank.infra.gateways.DonorRepositoryJpa;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.persistence.repositories.DonorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonorConfig {

    @Bean
    DonorMapper donorMapper() {
        return new DonorMapper();
    }

    @Bean
    GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors(DonorRepositoryGateway donorRepository) {
        return new GenerateReportOnActiveAndInactiveDonors(donorRepository);
    }

    @Bean
    DonorRepositoryJpa donorRepositoryJpa(DonorRepository donorRepository, DonorMapper donorMapper) {
        return new DonorRepositoryJpa(donorRepository, donorMapper);
    };

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
}
