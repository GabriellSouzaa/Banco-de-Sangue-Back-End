package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.infra.models.requests.DonorRequest;

public class UpdateDonor {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public UpdateDonor(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public void updateDonor(Long donorId, DonorRequest donorRequest){
        donorRepositoryGateway.updateDonor(donorId, donorRequest);
    }
}
