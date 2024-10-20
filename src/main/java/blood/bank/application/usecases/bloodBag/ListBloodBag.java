package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.domain.entities.bloodBag.BloodBag;

import java.util.List;

public class ListBloodBag {

    private final BloodBagRepositoryGateway bloodBagRepositoryGateway;

    public ListBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway) {
        this.bloodBagRepositoryGateway = bloodBagRepositoryGateway;
    }

    public List<BloodBag> getBloodBags() {
        return bloodBagRepositoryGateway.getBloodBags();
    }
}
