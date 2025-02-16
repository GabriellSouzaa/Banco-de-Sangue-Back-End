package blood.bank.infra.controller;

import blood.bank.application.usecases.requestHospitalClinic.*;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.models.requests.RequestHospitalClinicRequest;
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

    private final CreateRequestHospitalClinic createRequestHospitalClinic;

    private final UpdateRequestHospitalClinic updateRequestHospitalClinic;

    private final DeleteRequestHospitalClinic deleteRequestHospitalClinic;

    public RequestHospitalClinicController(ListRequestHospitalClinic listRequestHospitalClinic, UpdateStatusOfRequestHospitalClinic updateStatusOfRequestHospitalClinic, CreateRequestHospitalClinic createRequestHospitalClinic, UpdateRequestHospitalClinic updateRequestHospitalClinic, DeleteRequestHospitalClinic deleteRequestHospitalClinic) {
        this.listRequestHospitalClinic = listRequestHospitalClinic;
        this.updateStatusOfRequestHospitalClinic = updateStatusOfRequestHospitalClinic;
        this.createRequestHospitalClinic = createRequestHospitalClinic;
        this.updateRequestHospitalClinic = updateRequestHospitalClinic;
        this.deleteRequestHospitalClinic = deleteRequestHospitalClinic;
    }

    @GetMapping
    List<RequestHospitalClinicResponse> requestHospitalClinics(){
        List<RequestHospitalClinic> requestHospitalClinics =  listRequestHospitalClinic.getRequestsHospitalClinic();
        return requestHospitalClinics.stream().map(RequestHospitalClinicResponse::new).collect(Collectors.toList());
    }

    @PutMapping("/update-status/{dateOfRequest}/{status}")
    RequestHospitalClinicResponse updateStatusOfRequestHospitalClinic(@PathVariable LocalDateTime dateOfRequest, @PathVariable String status){
        RequestHospitalClinic requestHospitalClinic = this.updateStatusOfRequestHospitalClinic.updateStatusOfRequestHospitalClinic(dateOfRequest, status);
        return new RequestHospitalClinicResponse(requestHospitalClinic);
    }

    @PostMapping
    void createRequestHospitalClinic(@RequestBody RequestHospitalClinicRequest request) {
        this.createRequestHospitalClinic.createRequestHospitalClinic(request);
    }

    @PutMapping("/{id}")
    void updateRequestHospitalClinic(@PathVariable Long id, @RequestBody RequestHospitalClinicRequest request) {
        this.updateRequestHospitalClinic.updateRequestHospitalClinic(id, request);
    }

    @DeleteMapping("/{id}")
    void deleteRequestHospitalClinic(@PathVariable Long id){
        this.deleteRequestHospitalClinic.deleteRequestHospitalClinic(id);
    }
}
