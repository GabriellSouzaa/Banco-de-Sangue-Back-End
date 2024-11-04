package blood.bank.infra.controller;

import blood.bank.application.usecases.donation.GenerateReportDonationsMonth;
import blood.bank.application.usecases.donation.ListDonation;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.models.responses.DonationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donation")
@RestController
public class DonationController {

    private final ListDonation listDonation;

    private final GenerateReportDonationsMonth generateReportDonationsMonth;

    public DonationController(ListDonation listDonation, GenerateReportDonationsMonth generateReportDonationsMonth) {
        this.listDonation = listDonation;
        this.generateReportDonationsMonth = generateReportDonationsMonth;
    }

    @GetMapping
    public List<DonationResponse> getDonations(){
        List<Donation> donations = this.listDonation.getDonations();
        return donations.stream().map(DonationResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/report-donation")
    ResponseEntity<byte[]> generateReportOnActiveAndInactiveDonors(){
        return this.generateReportDonationsMonth.generateReportDonationsMonth();
    }

}
