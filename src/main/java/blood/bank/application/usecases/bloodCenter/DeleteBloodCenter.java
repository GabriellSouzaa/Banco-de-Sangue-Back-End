package blood.bank.application.usecases.bloodCenter;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;

public class DeleteBloodCenter {

    private final BloodCenterRepositoryGateway bloodCenterRepositoryGateway;

    public DeleteBloodCenter(BloodCenterRepositoryGateway bloodCenterRepositoryGateway) {
        this.bloodCenterRepositoryGateway = bloodCenterRepositoryGateway;
    }

    public void deleteById(Long id){
        this.bloodCenterRepositoryGateway.deleteBloodCenter(id);
    }
}
