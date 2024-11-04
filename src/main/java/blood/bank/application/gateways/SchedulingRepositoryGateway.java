package blood.bank.application.gateways;

import blood.bank.domain.entities.scheduling.Scheduling;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchedulingRepositoryGateway {

    List<Scheduling> getSchedulings();

    ResponseEntity<byte[]> generateReportSchedulingMonth();
}
