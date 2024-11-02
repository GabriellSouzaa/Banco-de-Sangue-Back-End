package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;

public class DeleteDonor {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public DeleteDonor(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public void deleteDonor(Long donorId){
        donorRepositoryGateway.deleteDonor(donorId);
    }
}
