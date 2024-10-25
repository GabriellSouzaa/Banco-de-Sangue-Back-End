package blood.bank.infra.controller;


import blood.bank.application.usecases.donor.AwardPoints;
import blood.bank.application.usecases.donor.ListDonor;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.AwardPointsRequest;
import blood.bank.infra.models.responses.DonorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donor")
public class DonorController {

    private final ListDonor listDonor;

    private final AwardPoints awardPoints;

    public DonorController(ListDonor listDonor, AwardPoints awardPoints) {
        this.listDonor = listDonor;
        this.awardPoints = awardPoints;
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
}
