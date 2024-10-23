package blood.bank.application.usecases.requestHospitalClinic;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;

import java.time.LocalDateTime;

public class UpdateStatusOfRequestHospitalClinic {

    private final RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway;

    public UpdateStatusOfRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        this.requestHospitalClinicRepositoryGateway = requestHospitalClinicRepositoryGateway;
    }

    public RequestHospitalClinic updateStatusOfRequestHospitalClinic(LocalDateTime dateOfRequest, String status) {
        return this.requestHospitalClinicRepositoryGateway.updateStatusOfRequestHospitalClinic( dateOfRequest, status);
    }
}
