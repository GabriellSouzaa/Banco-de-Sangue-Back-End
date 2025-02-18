package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.DonorMobileRequest;

public class CreateDonorMobile {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public CreateDonorMobile(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public Donor createDonorMobile(DonorMobileRequest donorMobileRequest) {
        return this.donorRepositoryGateway.createDonorMobile(donorMobileRequest);
    }
}
