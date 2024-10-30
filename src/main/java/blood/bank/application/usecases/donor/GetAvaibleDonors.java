package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;

import java.util.List;

public class GetAvaibleDonors {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public GetAvaibleDonors(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public List<Donor> getAvailableDonors() {
        return donorRepositoryGateway.getAvailableDonors();
    }
}
