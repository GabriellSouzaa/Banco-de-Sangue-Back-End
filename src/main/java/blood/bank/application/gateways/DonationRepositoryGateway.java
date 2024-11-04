package blood.bank.application.gateways;

import blood.bank.domain.entities.donation.Donation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonationRepositoryGateway {

    List<Donation> getDonations();

    ResponseEntity<byte[]> generateReportDonationsMonth();
}
