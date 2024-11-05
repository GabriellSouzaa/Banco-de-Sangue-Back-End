package blood.bank.application.usecases.bloodCenter;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.infra.models.requests.BloodCenterRequest;

public class UpdateBloodCenter {

    private final BloodCenterRepositoryGateway bloodCenterRepositoryGateway;

    public UpdateBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        this.bloodCenterRepositoryGateway = bloodCenterRepositoryGateway;
    }

    public void updateBloodCenter(Long id, BloodCenterRequest bloodCenterRequest) {
        this.bloodCenterRepositoryGateway.updateBloodCenter(id, bloodCenterRequest);
    }
}
