package blood.bank.application.usecases.scheduling;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import org.springframework.http.ResponseEntity;

public class GenerateReportSchedulingCanceled {

    private final SchedulingRepositoryGateway schedulingRepositoryGateway;

    public GenerateReportSchedulingCanceled(SchedulingRepositoryGateway schedulingRepositoryGateway) {
        this.schedulingRepositoryGateway = schedulingRepositoryGateway;
    }

    public ResponseEntity<byte[]> generateReportSchedulingCanceled(){
        return schedulingRepositoryGateway.generateReportSchedulingCanceled();
    }
}
