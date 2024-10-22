package blood.bank.application.gateways;

import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;

import java.util.List;

public interface RequestHospitalClinicRepositoryGateway {
    List<RequestHospitalClinic> getRequestsHospitalClinic();
}
