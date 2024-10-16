package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;

import java.util.List;

public class ListDonor {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public ListDonor(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public List<Donor> getDonors() {
        return donorRepositoryGateway.getDonors();
    }


}
