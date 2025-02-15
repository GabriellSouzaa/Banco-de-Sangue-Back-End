package blood.bank.application.gateways;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.models.requests.HospitalClinicRequest;

import java.util.List;

public interface HospitalClinicRepositoryGateway {
    List<HospitalClinic> getHospitalClinics();

    void createHospitalClinic(HospitalClinicRequest hospitalClinicRequest);

    void updateHospitalClinic(Long id, HospitalClinicRequest hospitalClinicRequest);

    void deleteHospitalClinic(Long id);
}
