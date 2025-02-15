package blood.bank.infra.controller;

import blood.bank.application.usecases.hospitalClinic.CreateHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.DeleteHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.ListHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.UpdateHospitalClinic;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.models.requests.HospitalClinicRequest;
import blood.bank.infra.models.responses.HospitalClinicResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hospital-clinic")
public class HospitalClinicController {

    private final ListHospitalClinic listHospitalClinic;

    private final CreateHospitalClinic createHospitalClinic;

    private final UpdateHospitalClinic updateHospitalClinic;

    private final DeleteHospitalClinic deleteHospitalClinic;

    public HospitalClinicController(ListHospitalClinic listHospitalClinic, CreateHospitalClinic createHospitalClinic, UpdateHospitalClinic updateHospitalClinic, DeleteHospitalClinic deleteHospitalClinic) {
        this.listHospitalClinic = listHospitalClinic;
        this.createHospitalClinic = createHospitalClinic;
        this.updateHospitalClinic = updateHospitalClinic;
        this.deleteHospitalClinic = deleteHospitalClinic;
    }

    @GetMapping
    List<HospitalClinicResponse> hospitalClinics(){
        List<HospitalClinic> hospitalClinics =  listHospitalClinic.getHospitalClinics();
        return hospitalClinics.stream().map(HospitalClinicResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    void createHospitalClinics(@RequestBody HospitalClinicRequest hospitalClinicRequest){
        createHospitalClinic.createHospitalClinic(hospitalClinicRequest);
    }

    @PutMapping("/{id}")
    void updateHospitalClinic(@PathVariable Long id, @RequestBody HospitalClinicRequest hospitalClinicRequest){
        updateHospitalClinic.updateHospitalClinic(id, hospitalClinicRequest);
    }

    @DeleteMapping("/{id}")
    void deleteHospitalClinic(@PathVariable Long id){
        deleteHospitalClinic.deleteHospitalClinic(id);
    }
}
