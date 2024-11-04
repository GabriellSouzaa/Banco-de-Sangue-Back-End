package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;

public class DeleteBloodBag {

    private final BloodBagRepositoryGateway bloodBagRepositoryGateway;

    public DeleteBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway) {
        this.bloodBagRepositoryGateway = bloodBagRepositoryGateway;
    }

    public void deleteBloodBag(String batchCode){
        bloodBagRepositoryGateway.deleteBloodBag(batchCode);
    }
}
