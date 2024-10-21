package blood.bank.application.usecases.hospitalClinic;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;

import java.util.List;

public class ListHospitalClinic {

    private final HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway;

    public ListHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway) {
        this.hospitalClinicRepositoryGateway = hospitalClinicRepositoryGateway;
    }

    public List<HospitalClinic> getHospitalClinics() {
        return hospitalClinicRepositoryGateway.getHospitalClinics();
    }
}
