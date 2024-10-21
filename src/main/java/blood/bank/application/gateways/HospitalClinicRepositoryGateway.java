package blood.bank.application.gateways;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;

import java.util.List;

public interface HospitalClinicRepositoryGateway {
    List<HospitalClinic> getHospitalClinics();
}
