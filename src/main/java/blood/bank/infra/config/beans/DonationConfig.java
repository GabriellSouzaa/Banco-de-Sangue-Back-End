package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.application.usecases.donation.ListDonation;
import blood.bank.infra.gateways.DonationRepositoryJpa;
import blood.bank.infra.persistence.repositories.DonationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonationConfig {

    @Bean
    DonationRepositoryJpa donationRepositoryJpa(DonationRepository donationRepository) {
        return new DonationRepositoryJpa(donationRepository);
    }

    @Bean
    ListDonation listDonation(DonationRepositoryGateway donationRepositoryGateway) {
        return new ListDonation(donationRepositoryGateway);
    }
}
