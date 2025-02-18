package blood.bank.infra.controller;


import blood.bank.application.usecases.donor.*;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.AwardPointsRequest;
import blood.bank.infra.models.requests.DonorMobileRequest;
import blood.bank.infra.models.requests.DonorRequest;
import blood.bank.infra.models.responses.DonorResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private final CreateDonorMobile createDonorMobile;

    public DonorController(ListDonor listDonor, AwardPoints awardPoints, GetAvaibleDonors getAvaibleDonors, GenerateReportOnActiveAndInactiveDonors generateReportOnActiveAndInactiveDonors, CreateDonor createDonor, UpdateDonor updateDonor, DeleteDonor deleteDonor, CreateDonorMobile createDonorMobile) {
        this.listDonor = listDonor;
        this.awardPoints = awardPoints;
        this.getAvaibleDonors = getAvaibleDonors;
        this.generateReportOnActiveAndInactiveDonors = generateReportOnActiveAndInactiveDonors;
        this.createDonor = createDonor;
        this.updateDonor = updateDonor;
        this.deleteDonor = deleteDonor;
        this.createDonorMobile = createDonorMobile;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    DonorResponse createDonor(
            @RequestPart("donor") DonorRequest donorRequest,
            @RequestPart("photo") MultipartFile photo
    ){
        Donor donor = this.createDonor.createDonor(donorRequest, photo);
        return new DonorResponse(donor);
    }

    @PostMapping("/create-donor-mobile")
    DonorResponse donorResponse(@RequestBody DonorMobileRequest donorMobileRequest){
        Donor donor = this.createDonorMobile.createDonorMobile(donorMobileRequest);
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
