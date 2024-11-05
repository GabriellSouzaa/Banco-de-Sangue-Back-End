package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;

public class DeleteSchedulingById {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public DeleteSchedulingById(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public void deleteById(Long id) {
        this.schedulingRepositoryGateway.deleteById(id);
    }
}
