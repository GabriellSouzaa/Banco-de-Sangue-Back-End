package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.infra.models.requests.BloodBagRequest;

public class CreateBloodBag {

    private final BloodBagRepositoryGateway bloodBagRepositoryGateway;

    public CreateBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway) {
        this.bloodBagRepositoryGateway = bloodBagRepositoryGateway;
    }

    public void createBloodBag(BloodBagRequest bloodBagRequest){
        this.bloodBagRepositoryGateway.createBloodBag(bloodBagRequest);
    }
}
