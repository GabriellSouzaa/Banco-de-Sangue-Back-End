package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonorRepositoryGateway;
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
    DonorRepositoryJpa donorRepositoryJpa(DonorRepository donorRepository, DonorMapper donorMapper) {
        return new DonorRepositoryJpa(donorRepository, donorMapper);
    };

    @Bean
    ListDonor listDonor (DonorRepositoryGateway donorRepositoryGateway) {
        return new ListDonor(donorRepositoryGateway);
    }
}
