package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.infra.models.requests.DonorRequest;

public class CreateDonor {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public CreateDonor(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public void createDonor(DonorRequest donorRequest) {
        this.donorRepositoryGateway.createDonor(donorRequest);
    }
}
