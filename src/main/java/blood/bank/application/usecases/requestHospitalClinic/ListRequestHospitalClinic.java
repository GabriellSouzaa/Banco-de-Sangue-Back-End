package blood.bank.application.usecases.requestHospitalClinic;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;

import java.util.List;

public class ListRequestHospitalClinic {

    private final RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway;

    public ListRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        this.requestHospitalClinicRepositoryGateway = requestHospitalClinicRepositoryGateway;
    }

    public List<RequestHospitalClinic> getRequestsHospitalClinic(){
        return requestHospitalClinicRepositoryGateway.getRequestsHospitalClinic();
    }
}
