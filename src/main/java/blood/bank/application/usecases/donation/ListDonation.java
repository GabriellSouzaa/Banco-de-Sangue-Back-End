package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.domain.entities.donation.Donation;

import java.util.List;

public class ListDonation {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public ListDonation(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public List<Donation> getDonations() {
        return donationRepositoryGateway.getDonations();
    }
}
