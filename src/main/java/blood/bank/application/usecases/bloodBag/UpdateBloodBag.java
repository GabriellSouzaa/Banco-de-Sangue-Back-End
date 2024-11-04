package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.infra.models.requests.BloodBagRequest;

public class UpdateBloodBag {

    private final BloodBagRepositoryGateway bloodBagRepositoryGateway;

    public UpdateBloodBag(BloodBagRepositoryGateway bloodBagRepositoryGateway) {
        this.bloodBagRepositoryGateway = bloodBagRepositoryGateway;
    }

    public void updateBloodBag(String batchCode, BloodBagRequest bloodBagRequest){
        this.bloodBagRepositoryGateway.updateBloodBag(batchCode, bloodBagRequest);
    }
}
