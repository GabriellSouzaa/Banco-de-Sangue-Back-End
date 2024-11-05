package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.infra.models.requests.SchedulingRequest;

public class CreateScheduling {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public CreateScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public void createScheduling(Long idDonor, SchedulingRequest schedulingRequest) {
        this.schedulingRepositoryGateway.createScheduling(idDonor,schedulingRequest);
    }
}
