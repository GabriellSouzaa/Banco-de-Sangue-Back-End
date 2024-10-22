package blood.bank.infra.gateways;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.mappers.RequestHospitalClinicEntityMapper;
import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;
import blood.bank.infra.persistence.repositories.RequestHospitalClinicRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RequestHospitalClinicJpa implements RequestHospitalClinicRepositoryGateway {

    private final RequestHospitalClinicRepository requestHospitalClinicRepository;

    private final RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper;

    public RequestHospitalClinicJpa(RequestHospitalClinicRepository requestHospitalClinicRepository, RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper) {
        this.requestHospitalClinicRepository = requestHospitalClinicRepository;
        this.requestHospitalClinicEntityMapper = requestHospitalClinicEntityMapper;
    }

    @Override
    public List<RequestHospitalClinic> getRequestsHospitalClinic() {
        List<RequestHospitalClinicEntity> requestsHospitalClinic = requestHospitalClinicRepository.findAll();
        return requestsHospitalClinic.stream().map(RequestHospitalClinicEntityMapper::toRequestHospitalClinic).collect(Collectors.toList());
    }
}
