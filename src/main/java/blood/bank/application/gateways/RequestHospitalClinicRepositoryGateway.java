package blood.bank.application.gateways;

import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestHospitalClinicRepositoryGateway {

    List<RequestHospitalClinic> getRequestsHospitalClinic();

    RequestHospitalClinic updateStatusOfRequestHospitalClinic(LocalDateTime dateOfRequest);
}
