package blood.bank.application.usecases.bloodCenter;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.domain.entities.bloodCenter.BloodCenter;

import java.util.List;

public class ListBloodCenter {

    private final BloodCenterRepositoryGateway bloodCenterRepositoryGateway;

    public ListBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        this.bloodCenterRepositoryGateway = bloodCenterRepositoryGateway;
    }

    public List<BloodCenter> getBloodCenters() {
        return bloodCenterRepositoryGateway.getBloodCenters();
    }
}
