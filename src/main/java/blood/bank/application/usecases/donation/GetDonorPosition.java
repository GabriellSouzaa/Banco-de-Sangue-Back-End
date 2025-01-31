package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;

public class GetDonorPosition {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public GetDonorPosition(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public Integer getDonorPosition(Long idDonor) {
        return donationRepositoryGateway.getDonorPosition(idDonor);
    }
}
