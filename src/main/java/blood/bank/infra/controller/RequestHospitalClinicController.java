package blood.bank.infra.controller;

import blood.bank.application.usecases.requestHospitalClinic.ListRequestHospitalClinic;
import blood.bank.application.usecases.requestHospitalClinic.UpdateStatusOfRequestHospitalClinic;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.models.responses.RequestHospitalClinicResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/request-hospital-clinic")
public class RequestHospitalClinicController {

    private final ListRequestHospitalClinic listRequestHospitalClinic;

    private final UpdateStatusOfRequestHospitalClinic  updateStatusOfRequestHospitalClinic;

    public RequestHospitalClinicController(ListRequestHospitalClinic listRequestHospitalClinic, UpdateStatusOfRequestHospitalClinic updateStatusOfRequestHospitalClinic) {
        this.listRequestHospitalClinic = listRequestHospitalClinic;
        this.updateStatusOfRequestHospitalClinic = updateStatusOfRequestHospitalClinic;
    }

    @GetMapping
    List<RequestHospitalClinicResponse> requestHospitalClinics(){
        List<RequestHospitalClinic> requestHospitalClinics =  listRequestHospitalClinic.getRequestsHospitalClinic();
        return requestHospitalClinics.stream().map(RequestHospitalClinicResponse::new).collect(Collectors.toList());
    }

    @PutMapping("/update-status/{dateOfRequest}")
    RequestHospitalClinicResponse updateStatusOfRequestHospitalClinic(@PathVariable LocalDateTime dateOfRequest){
        RequestHospitalClinic requestHospitalClinic = this.updateStatusOfRequestHospitalClinic.updateStatusOfRequestHospitalClinic(dateOfRequest);
        return new RequestHospitalClinicResponse(requestHospitalClinic);
    }
}
