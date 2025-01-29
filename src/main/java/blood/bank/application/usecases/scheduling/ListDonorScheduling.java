package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.domain.entities.scheduling.Scheduling;

import java.util.List;

public class ListDonorScheduling {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public ListDonorScheduling(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public List<Scheduling> getDonorSchedulings(Long idDonor){
        return schedulingRepositoryGateway.getSchedulingsByDonor(idDonor);
    }
}
