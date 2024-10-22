package blood.bank.infra.controller;

import blood.bank.application.usecases.requestHospitalClinic.ListRequestHospitalClinic;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.models.responses.RequestHospitalClinicResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/request-hospital-clinic")
public class RequestHospitalClinicController {

    private final ListRequestHospitalClinic listRequestHospitalClinic;

    public RequestHospitalClinicController(ListRequestHospitalClinic listRequestHospitalClinic) {
        this.listRequestHospitalClinic = listRequestHospitalClinic;
    }

    @GetMapping
    List<RequestHospitalClinicResponse> requestHospitalClinics(){
        List<RequestHospitalClinic> requestHospitalClinics =  listRequestHospitalClinic.getRequestsHospitalClinic();
        return requestHospitalClinics.stream().map(RequestHospitalClinicResponse::new).collect(Collectors.toList());
    }
}
