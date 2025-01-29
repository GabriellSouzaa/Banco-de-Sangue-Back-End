package blood.bank.application.gateways;

import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.models.requests.SchedulingRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchedulingRepositoryGateway {

    List<Scheduling> getSchedulings();

    ResponseEntity<byte[]> generateReportSchedulingMonth();

    ResponseEntity<byte[]> generateReportSchedulingCanceled();

    void createScheduling(Long idDonor, SchedulingRequest schedulingRequest);

    void updateScheduling(Long id, SchedulingRequest schedulingRequest);

    void deleteById(Long id);

    List<Scheduling> getSchedulingsByDonor(Long idDonor);
}
