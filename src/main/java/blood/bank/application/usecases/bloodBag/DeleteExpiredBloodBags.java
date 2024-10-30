package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;

public class DeleteExpiredBloodBags {

    private final BloodBagRepositoryGateway bloodBagRepositoryGateway;

    public DeleteExpiredBloodBags(BloodBagRepositoryGateway bloodBagRepositoryGateway) {
        this.bloodBagRepositoryGateway = bloodBagRepositoryGateway;
    }

    public void deleteExpiredBloodBags() {
        bloodBagRepositoryGateway.deleteExpiredBloodBags();
    }
}
