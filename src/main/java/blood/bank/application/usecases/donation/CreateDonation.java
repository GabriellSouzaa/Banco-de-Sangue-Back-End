package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.infra.models.requests.DonationRequest;

public class CreateDonation {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public CreateDonation(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public void createDonation(Long id, DonationRequest donationRequest) {
        this.donationRepositoryGateway.createDonation(id, donationRequest);
    }
}
