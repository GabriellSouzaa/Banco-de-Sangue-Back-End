package blood.bank.infra.controller;


import blood.bank.application.usecases.donor.ListDonor;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.responses.DonorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donor")
public class DonorController {

    private final ListDonor listDonor;

    public DonorController(ListDonor listDonor) {
        this.listDonor = listDonor;
    }

    @GetMapping
    List<DonorResponse> donors(){
        List<Donor> donors =  listDonor.getDonors();
        return donors.stream().map(DonorResponse::new).collect(Collectors.toList());
    }
}
