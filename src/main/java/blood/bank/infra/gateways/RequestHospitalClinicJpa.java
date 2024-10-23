package blood.bank.infra.gateways;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.mappers.RequestHospitalClinicEntityMapper;
import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;
import blood.bank.infra.persistence.repositories.RequestHospitalClinicRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    @Override
    public RequestHospitalClinic updateStatusOfRequestHospitalClinic(LocalDateTime dateOfRequest) {
        Optional<RequestHospitalClinicEntity> requestHospitalClinicEntity
                = this.requestHospitalClinicRepository.findByRequestDate(dateOfRequest);

        if(requestHospitalClinicEntity.isEmpty()){
            throw new RuntimeException("Não existe Solitação com essa data");
        } else {
            RequestHospitalClinicEntity requestHospitalClinic =  requestHospitalClinicEntity.get();
            requestHospitalClinic.setRequestStatus("Atendida");

            this.requestHospitalClinicRepository.save(requestHospitalClinic);
        }
        return RequestHospitalClinicEntityMapper.toRequestHospitalClinic(requestHospitalClinicEntity.get());
    }
}
