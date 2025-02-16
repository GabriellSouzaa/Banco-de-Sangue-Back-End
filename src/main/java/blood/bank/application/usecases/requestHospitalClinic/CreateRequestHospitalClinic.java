package blood.bank.application.usecases.requestHospitalClinic;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.infra.models.requests.RequestHospitalClinicRequest;

public class CreateRequestHospitalClinic {

    private final RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway;

    public CreateRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        this.requestHospitalClinicRepositoryGateway = requestHospitalClinicRepositoryGateway;
    }

    public void createRequestHospitalClinic(RequestHospitalClinicRequest request) {
        this.requestHospitalClinicRepositoryGateway.createRequestHospitalClinic(request);
    }
}
