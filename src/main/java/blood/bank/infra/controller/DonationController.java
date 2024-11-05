package blood.bank.infra.controller;

import blood.bank.application.usecases.donation.*;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.models.requests.DonationRequest;
import blood.bank.infra.models.responses.DonationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donation")
@RestController
public class DonationController {

    private final ListDonation listDonation;

    private final GenerateReportDonationsMonth generateReportDonationsMonth;

    private final CreateDonation createDonation;

    private final DeleteDonation deleteDonation;

    private final UpdateDonation updateDonation;

    public DonationController(ListDonation listDonation, GenerateReportDonationsMonth generateReportDonationsMonth, CreateDonation createDonation, DeleteDonation deleteDonation, UpdateDonation updateDonation) {
        this.listDonation = listDonation;
        this.generateReportDonationsMonth = generateReportDonationsMonth;
        this.createDonation = createDonation;
        this.deleteDonation = deleteDonation;
        this.updateDonation = updateDonation;
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

    @PostMapping("/create/{idDonor}")
    public void createDonation(@PathVariable Long idDonor, @RequestBody DonationRequest donationRequest){
        this.createDonation.createDonation(idDonor, donationRequest);
    }

    @PutMapping("/update/{idDonation}")
    public void updateDonation(@PathVariable Long idDonation, @RequestBody DonationRequest donationRequest){
        this.updateDonation.updateDonation(idDonation, donationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteByDateOfDonation(@PathVariable Long id){
        this.deleteDonation.deleteDonation(id);
    }

}
