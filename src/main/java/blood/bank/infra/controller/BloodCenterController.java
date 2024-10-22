package blood.bank.infra.controller;

import blood.bank.application.usecases.bloodCenter.ListBloodCenter;
import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.models.responses.BloodCenterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/blood-center")
public class BloodCenterController {

    private final ListBloodCenter listBloodCenter;

    public BloodCenterController(ListBloodCenter listBloodCenter) {
        this.listBloodCenter = listBloodCenter;
    }

    @GetMapping
    public List<BloodCenterResponse> getAllBloodCenters() {
        List<BloodCenter> bloodCenters = listBloodCenter.getBloodCenters();
        return bloodCenters.stream().map(BloodCenterResponse::new).collect(Collectors.toList());
    }
}
