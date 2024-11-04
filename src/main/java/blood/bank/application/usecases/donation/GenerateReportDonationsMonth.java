package blood.bank.application.usecases.donation;

import blood.bank.application.gateways.DonationRepositoryGateway;
import org.springframework.http.ResponseEntity;

public class GenerateReportDonationsMonth {

    private final DonationRepositoryGateway donationRepositoryGateway;

    public GenerateReportDonationsMonth(DonationRepositoryGateway donationRepositoryGateway) {
        this.donationRepositoryGateway = donationRepositoryGateway;
    }

    public ResponseEntity<byte[]> generateReportDonationsMonth() {
        return donationRepositoryGateway.generateReportDonationsMonth();
    }
}
