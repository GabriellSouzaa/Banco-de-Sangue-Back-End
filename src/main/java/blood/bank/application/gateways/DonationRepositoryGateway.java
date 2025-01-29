package blood.bank.application.gateways;

import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.models.requests.DonationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonationRepositoryGateway {

    List<Donation> getDonations();

    List<Donation> getDonorDonations(Long idDonor);

    ResponseEntity<byte[]> generateReportDonationsMonth();

    void createDonation(Long idDonor, DonationRequest donationRequest);

    void updateDonation(Long id, DonationRequest donationRequest);

    void deleteDonation(Long id);
}
