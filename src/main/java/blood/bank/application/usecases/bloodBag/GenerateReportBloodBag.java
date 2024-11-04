package blood.bank.application.usecases.bloodBag;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import org.springframework.http.ResponseEntity;

public class GenerateReportBloodBag {

    private final BloodBagRepositoryGateway gateway;

    public GenerateReportBloodBag(BloodBagRepositoryGateway gateway) {
        this.gateway = gateway;
    }

    public ResponseEntity<byte[]> generateReport() {
        return this.gateway.generateReportBloodBag();
    }
}
