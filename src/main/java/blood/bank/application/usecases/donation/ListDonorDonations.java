package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.domain.entities.donation.Donation;

import java.util.List;

public class ListDonorDonations {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public ListDonorDonations(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public List<Donation> getDonorDonations(Long idDonor) {
        return donationRepositoryGateway.getDonorDonations(idDonor);
    }
}
