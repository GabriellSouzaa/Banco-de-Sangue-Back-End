package blood.bank.infra.controller;

import blood.bank.application.usecases.donation.ListDonation;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.models.responses.DonationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donation")
@RestController
public class DonationController {

    private final ListDonation listDonation;

    public DonationController(ListDonation listDonation) {
        this.listDonation = listDonation;
    }

    @GetMapping
    public List<DonationResponse> getDonations(){
        List<Donation> donations = this.listDonation.getDonations();
        return donations.stream().map(DonationResponse::new).collect(Collectors.toList());
    }
}
