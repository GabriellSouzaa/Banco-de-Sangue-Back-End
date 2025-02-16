package blood.bank.application.usecases.requestHospitalClinic;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.infra.models.requests.RequestHospitalClinicRequest;

public class UpdateRequestHospitalClinic {

    private final RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway;

    public UpdateRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        this.requestHospitalClinicRepositoryGateway = requestHospitalClinicRepositoryGateway;
    }

    public void updateRequestHospitalClinic(Long id, RequestHospitalClinicRequest request) {
        this.requestHospitalClinicRepositoryGateway.updateRequestHospitalClinic(id, request);
    }
}
