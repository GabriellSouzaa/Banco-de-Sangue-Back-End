package blood.bank.application.usecases.hospitalClinic;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.infra.models.requests.HospitalClinicRequest;

public class CreateHospitalClinic {

    private final HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway;

    public CreateHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway) {
        this.hospitalClinicRepositoryGateway = hospitalClinicRepositoryGateway;
    }

    public void createHospitalClinic(HospitalClinicRequest hospitalClinicRequest) {
        this.hospitalClinicRepositoryGateway.createHospitalClinic(hospitalClinicRequest);
    }
}
