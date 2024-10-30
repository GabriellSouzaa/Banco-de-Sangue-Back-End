package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.domain.entities.scheduling.Scheduling;

import java.util.List;

public class ListScheduling {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public ListScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public List<Scheduling> getSchedulings(){
        return schedulingRepositoryGateway.getSchedulings();
    }
}
