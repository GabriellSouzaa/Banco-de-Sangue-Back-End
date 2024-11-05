package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.infra.models.requests.DonationRequest;

public class UpdateDonation {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public UpdateDonation(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public void updateDonation(Long id, DonationRequest donationRequest) {
        this.donationRepositoryGateway.updateDonation(id, donationRequest);
    }
}
