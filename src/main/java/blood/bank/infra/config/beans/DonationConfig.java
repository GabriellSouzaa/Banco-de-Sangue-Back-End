package blood.bank.infra.config.beans;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.application.usecases.donation.*;
import blood.bank.infra.gateways.DonationRepositoryJpa;
import blood.bank.infra.persistence.repositories.DonationRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonationConfig {

    @Bean
    DonationRepositoryJpa donationRepositoryJpa(DonationRepository donationRepository, DonorRepository donorRepository) {
        return new DonationRepositoryJpa(donationRepository, donorRepository);
    }

    @Bean
    ListDonation listDonation(DonationRepositoryGateway donationRepositoryGateway) {
        return new ListDonation(donationRepositoryGateway);
    }

    @Bean
    GenerateReportDonationsMonth generateReportDonationsMonth(DonationRepositoryGateway donationRepository) {
        return new GenerateReportDonationsMonth(donationRepository);
    }

    @Bean
    CreateDonation createDonation(DonationRepositoryGateway donationRepositoryGateway) {
        return new CreateDonation(donationRepositoryGateway);
    }

    @Bean
    UpdateDonation updateDonation(DonationRepositoryGateway donationRepositoryGateway) {
        return new UpdateDonation(donationRepositoryGateway);
    }

    @Bean
    DeleteDonation deleteDonation(DonationRepositoryGateway donationRepositoryGateway) {
        return new DeleteDonation(donationRepositoryGateway);
    }

    @Bean
    ListDonorDonations listDonorDonations(DonationRepositoryGateway donationRepositoryGateway) {
        return new ListDonorDonations(donationRepositoryGateway);
    }

    @Bean
    GetDonorPosition getDonorPosition(DonationRepositoryGateway donationRepositoryGateway) {
        return new GetDonorPosition(donationRepositoryGateway);
    }
}
