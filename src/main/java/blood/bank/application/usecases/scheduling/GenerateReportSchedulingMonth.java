package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import org.springframework.http.ResponseEntity;

public class GenerateReportSchedulingMonth {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public GenerateReportSchedulingMonth(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public ResponseEntity<byte[]> generateReportSchedulingMonth(){
        return this.schedulingRepositoryGateway.generateReportSchedulingMonth();
    }
}
