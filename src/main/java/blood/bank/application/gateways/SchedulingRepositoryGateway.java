package blood.bank.application.gateways;

import blood.bank.domain.entities.scheduling.Scheduling;

import java.util.List;

public interface SchedulingRepositoryGateway {

    List<Scheduling> getSchedulings();
}
