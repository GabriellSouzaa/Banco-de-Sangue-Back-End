package blood.bank.application.usecases.bloodCenter;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.infra.models.requests.BloodCenterRequest;

public class CreateBloodCenter {

    private final BloodCenterRepositoryGateway bloodCenterRepositoryGateway;

    public CreateBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        this.bloodCenterRepositoryGateway = bloodCenterRepositoryGateway;
    }

    public void createBloodCenter(BloodCenterRequest bloodCenterRequest) {
        this.bloodCenterRepositoryGateway.createBloodCenter(bloodCenterRequest);
    }
}
