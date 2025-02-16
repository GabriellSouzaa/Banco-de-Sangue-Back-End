package blood.bank.application.gateways;

import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.models.requests.RequestHospitalClinicRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestHospitalClinicRepositoryGateway {

    List<RequestHospitalClinic> getRequestsHospitalClinic();

    RequestHospitalClinic updateStatusOfRequestHospitalClinic(LocalDateTime dateOfRequest, String status);

    void createRequestHospitalClinic(RequestHospitalClinicRequest hospitalClinicRequest);

    void updateRequestHospitalClinic(Long id, RequestHospitalClinicRequest hospitalClinicRequest);

    void deleteRequestHospitalClinic(Long id);
}
