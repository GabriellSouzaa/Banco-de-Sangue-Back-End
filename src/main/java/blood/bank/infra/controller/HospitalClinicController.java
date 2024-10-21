package blood.bank.infra.controller;

import blood.bank.application.usecases.hospitalClinic.ListHospitalClinic;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.models.responses.HospitalClinicResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hospital-clinic")
public class HospitalClinicController {

    private final ListHospitalClinic listHospitalClinic;

    public HospitalClinicController(ListHospitalClinic listHospitalClinic) {
        this.listHospitalClinic = listHospitalClinic;
    }

    @GetMapping
    List<HospitalClinicResponse> hospitalClinics(){
        List<HospitalClinic> hospitalClinics =  listHospitalClinic.getHospitalClinics();
        return hospitalClinics.stream().map(HospitalClinicResponse::new).collect(Collectors.toList());
    }

}
