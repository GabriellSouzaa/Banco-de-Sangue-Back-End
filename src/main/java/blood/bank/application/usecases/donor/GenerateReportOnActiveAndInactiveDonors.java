package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import org.springframework.http.ResponseEntity;

public class GenerateReportOnActiveAndInactiveDonors {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public GenerateReportOnActiveAndInactiveDonors(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public ResponseEntity<byte[]> generateReportOnActiveAndInactiveDonors() {
        return this.donorRepositoryGateway.generateReportOnActiveAndInactiveDonors();
    }
}
