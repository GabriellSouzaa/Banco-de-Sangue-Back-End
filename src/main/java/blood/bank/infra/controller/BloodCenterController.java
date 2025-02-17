package blood.bank.infra.controller;

import blood.bank.application.usecases.bloodCenter.CreateBloodCenter;
import blood.bank.application.usecases.bloodCenter.DeleteBloodCenter;
import blood.bank.application.usecases.bloodCenter.ListBloodCenter;
import blood.bank.application.usecases.bloodCenter.UpdateBloodCenter;
import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.models.requests.BloodCenterRequest;
import blood.bank.infra.models.responses.BloodCenterResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/blood-center")
public class BloodCenterController {

    private final ListBloodCenter listBloodCenter;

    private final CreateBloodCenter createBloodCenter;

    private final UpdateBloodCenter updateBloodCenter;

    private final DeleteBloodCenter deleteBloodCenter;


    public BloodCenterController(ListBloodCenter listBloodCenter, CreateBloodCenter createBloodCenter, UpdateBloodCenter updateBloodCenter, DeleteBloodCenter deleteBloodCenter) {
        this.listBloodCenter = listBloodCenter;
        this.createBloodCenter = createBloodCenter;
        this.updateBloodCenter = updateBloodCenter;
        this.deleteBloodCenter = deleteBloodCenter;
    }

    @GetMapping
    public List<BloodCenterResponse> getAllBloodCenters() {
        List<BloodCenter> bloodCenters = listBloodCenter.getBloodCenters();
        return bloodCenters.stream().map(BloodCenterResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public void createBloodCenter(@RequestBody BloodCenterRequest bloodCenterRequest)
    {
        this.createBloodCenter.createBloodCenter(bloodCenterRequest);
    }

    @PutMapping("/update/{id}")
    public void updateBloodCenter(@PathVariable Long id, @RequestBody BloodCenterRequest bloodCenterRequest) {
        this.updateBloodCenter.updateBloodCenter(id, bloodCenterRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBloodCenter(@PathVariable Long id) {
        this.deleteBloodCenter.deleteById(id);
    }
}
