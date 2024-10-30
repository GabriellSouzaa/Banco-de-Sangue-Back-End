package blood.bank.infra.controller;

import blood.bank.application.usecases.bloodBag.DeleteExpiredBloodBags;
import blood.bank.application.usecases.bloodBag.ListBloodBag;
import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.models.responses.BloodBagResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/blood-bag")
public class BloodBagController {

    private final ListBloodBag listBloodBag;

    private final DeleteExpiredBloodBags deleteExpiredBloodBags;

    public BloodBagController(ListBloodBag listBloodBag, DeleteExpiredBloodBags deleteExpiredBloodBags) {
        this.listBloodBag = listBloodBag;
        this.deleteExpiredBloodBags = deleteExpiredBloodBags;
    }

    @GetMapping
    List<BloodBagResponse> bloodBags(){
        List<BloodBag> bloodBags = listBloodBag.getBloodBags();
        return bloodBags.stream().map(BloodBagResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping("/delete-expired-blood-bags")
    void deleteExpiredBloodBags(){
        this.deleteExpiredBloodBags.deleteExpiredBloodBags();
    }
}
