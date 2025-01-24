package blood.bank.infra.controller;


import blood.bank.application.usecases.donor.*;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.AwardPointsRequest;
import blood.bank.infra.models.requests.DonorRequest;
import blood.bank.infra.models.responses.DonorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donor")
public class DonorController {

    private final ListDonor listDonor;

    private final AwardPoints awardPoints;

    private final GetAvaibleDonors getAvaibleDonors;

    private final GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors;

    private final CreateDonor createDonor;

    private final UpdateDonor updateDonor;

    private final DeleteDonor deleteDonor;

    public DonorController(ListDonor listDonor, AwardPoints awardPoints, GetAvaibleDonors getAvaibleDonors, GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors, CreateDonor createDonor, UpdateDonor updateDonor, DeleteDonor deleteDonor) {
        this.listDonor = listDonor;
        this.awardPoints = awardPoints;
        this.getAvaibleDonors = getAvaibleDonors;
        this.generateReportOnActiveAndInactiveDonors = generateReportOnActiveAndInactiveDonors;
        this.createDonor = createDonor;
        this.updateDonor = updateDonor;
        this.deleteDonor = deleteDonor;
    }

    @GetMapping
    List<DonorResponse> donors(){
        List<Donor> donors =  listDonor.getDonors();
        return donors.stream().map(DonorResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/award-points")
    DonorResponse awardPoints(@RequestBody AwardPointsRequest awardPointsRequest){
        Donor donor = awardPoints.awardPoints(awardPointsRequest.getDonorFullName(), awardPointsRequest.getDonorEmail(), awardPointsRequest.getPoints());
        return new DonorResponse(donor);
    }

    @GetMapping("/avaible-donors")
    List<DonorResponse> getAvaibleDonors(){
        List<Donor> avaibleDonors = getAvaibleDonors.getAvailableDonors();
        return avaibleDonors.stream().map(DonorResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/report-active-inactive-donors")
    ResponseEntity<byte[]> generateReportOnActiveAndInactiveDonors(){
        return this.generateReportOnActiveAndInactiveDonors.generateReportOnActiveAndInactiveDonors();
    }

    @PostMapping
    DonorResponse createDonor(@RequestBody DonorRequest donorRequest){
        Donor donor = this.createDonor.createDonor(donorRequest);
        return new DonorResponse(donor);
    }

    @PutMapping("/{id}")
    void updateDonor(@PathVariable Long id, @RequestBody DonorRequest donorRequest){
        this.updateDonor.updateDonor(id, donorRequest);
    }

    @DeleteMapping("/{id}")
    void deleteDonor(@PathVariable Long id){
        this.deleteDonor.deleteDonor(id);
    }
}
