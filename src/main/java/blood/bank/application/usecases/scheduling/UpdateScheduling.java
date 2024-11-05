package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.infra.models.requests.SchedulingRequest;

public class UpdateScheduling {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public UpdateScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public void updateScheduling(Long id, SchedulingRequest schedulingRequest) {
        this.schedulingRepositoryGateway.updateScheduling(id, schedulingRequest);
    }
}
