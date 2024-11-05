package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;

import java.time.LocalDate;

public class DeleteDonation {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public DeleteDonation(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public void deleteDonation(Long id) {
         this.donationRepositoryGateway.deleteDonation(id);
    }
}
