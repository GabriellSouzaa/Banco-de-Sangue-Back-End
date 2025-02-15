package blood.bank.application.usecases.hospitalClinic;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.infra.models.requests.HospitalClinicRequest;

public class UpdateHospitalClinic {

    private final HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway;

    public UpdateHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway) {
        this.hospitalClinicRepositoryGateway = hospitalClinicRepositoryGateway;
    }

    public void updateHospitalClinic(Long id, HospitalClinicRequest hospitalClinicRequest){
        this.hospitalClinicRepositoryGateway.updateHospitalClinic(id, hospitalClinicRequest);
    }
}
