package blood.bank.infra.controller;


import blood.bank.application.usecases.donor.AwardPoints;
import blood.bank.application.usecases.donor.GenerateReportOnActiveAndInactiveDonors;
import blood.bank.application.usecases.donor.GetAvaibleDonors;
import blood.bank.application.usecases.donor.ListDonor;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.AwardPointsRequest;
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

    public DonorController(ListDonor listDonor, AwardPoints awardPoints, GetAvaibleDonors getAvaibleDonors, GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors) {
        this.listDonor = listDonor;
        this.awardPoints = awardPoints;
        this.getAvaibleDonors = getAvaibleDonors;
        this.generateReportOnActiveAndInactiveDonors = generateReportOnActiveAndInactiveDonors;
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
}
