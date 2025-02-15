package blood.bank.application.usecases.hospitalClinic;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;

public class DeleteHospitalClinic {

    private final HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway;

    public DeleteHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway) {
        this.hospitalClinicRepositoryGateway = hospitalClinicRepositoryGateway;
    }

    public void deleteHospitalClinic(Long id){
        this.hospitalClinicRepositoryGateway.deleteHospitalClinic(id);
    }
}
