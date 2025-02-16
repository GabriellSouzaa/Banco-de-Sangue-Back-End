package blood.bank.application.usecases.requestHospitalClinic;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;

public class DeleteRequestHospitalClinic {

    private final RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway;

    public DeleteRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        this.requestHospitalClinicRepositoryGateway = requestHospitalClinicRepositoryGateway;
    }

    public void deleteRequestHospitalClinic(Long id) {
        this.requestHospitalClinicRepositoryGateway.deleteRequestHospitalClinic(id);
    }
}
