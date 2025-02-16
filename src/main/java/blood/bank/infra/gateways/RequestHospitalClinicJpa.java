package blood.bank.infra.gateways;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.mappers.RequestHospitalClinicEntityMapper;
import blood.bank.infra.models.requests.RequestHospitalClinicRequest;
import blood.bank.infra.persistence.models.HospitalClinicEntity;
import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;
import blood.bank.infra.persistence.repositories.HospitalClinicRepository;
import blood.bank.infra.persistence.repositories.RequestHospitalClinicRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestHospitalClinicJpa implements RequestHospitalClinicRepositoryGateway {

    private final RequestHospitalClinicRepository requestHospitalClinicRepository;

    private final RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper;

    private final HospitalClinicRepository hospitalClinicRepository;

    public RequestHospitalClinicJpa(RequestHospitalClinicRepository requestHospitalClinicRepository, RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper, HospitalClinicRepository hospitalClinicRepository) {
        this.requestHospitalClinicRepository = requestHospitalClinicRepository;
        this.requestHospitalClinicEntityMapper = requestHospitalClinicEntityMapper;
        this.hospitalClinicRepository = hospitalClinicRepository;
    }

    @Override
    public List<RequestHospitalClinic> getRequestsHospitalClinic() {
        List<RequestHospitalClinicEntity> requestsHospitalClinic = requestHospitalClinicRepository.findAll();
        return requestsHospitalClinic.stream().map(RequestHospitalClinicEntityMapper::toRequestHospitalClinic).collect(Collectors.toList());
    }

    @Override
    public RequestHospitalClinic updateStatusOfRequestHospitalClinic(LocalDateTime dateOfRequest, String status) {
        Optional<RequestHospitalClinicEntity> requestHospitalClinicEntity
                = this.requestHospitalClinicRepository.findByRequestDate(dateOfRequest);

        if(requestHospitalClinicEntity.isEmpty()){
            throw new RuntimeException("Não existe Solitação com essa data");
        } else {
            RequestHospitalClinicEntity requestHospitalClinic =  requestHospitalClinicEntity.get();
            requestHospitalClinic.setRequestStatus(status);

            this.requestHospitalClinicRepository.save(requestHospitalClinic);
        }
        return RequestHospitalClinicEntityMapper.toRequestHospitalClinic(requestHospitalClinicEntity.get());
    }

    @Override
    public void createRequestHospitalClinic(RequestHospitalClinicRequest hospitalClinicRequest) {
        RequestHospitalClinicEntity requestHospitalClinicEntity = new RequestHospitalClinicEntity();
        HospitalClinicEntity hospitalClinicEntity = hospitalClinicRepository.findById(hospitalClinicRequest.getHospitalClinicId())
                .orElseThrow(() -> new EntityNotFoundException("Hospital Clinic not found"));
        requestHospitalClinicEntity.setHospitalClinic(hospitalClinicEntity);
        requestHospitalClinicEntity.setRequestDate(hospitalClinicRequest.getRequestDate());
        requestHospitalClinicEntity.setRequestedBloodType(hospitalClinicRequest.getRequestedBloodType());
        requestHospitalClinicEntity.setRequestedBloodComponent(hospitalClinicRequest.getRequestedBloodComponent());
        requestHospitalClinicEntity.setRequestedQuantity(hospitalClinicRequest.getRequestedQuantity());
        requestHospitalClinicEntity.setNeedByDate(hospitalClinicRequest.getNeedByDate());
        requestHospitalClinicEntity.setRequestStatus(hospitalClinicRequest.getRequestStatus());
        requestHospitalClinicEntity.setObservation(hospitalClinicRequest.getObservation());
        this.requestHospitalClinicRepository.save(requestHospitalClinicEntity);
    }

    @Override
    public void updateRequestHospitalClinic(Long id, RequestHospitalClinicRequest hospitalClinicRequest) {
        RequestHospitalClinicEntity requestHospitalClinicEntity = requestHospitalClinicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Clinic not found"));
        requestHospitalClinicEntity.setRequestDate(hospitalClinicRequest.getRequestDate());
        requestHospitalClinicEntity.setRequestedBloodType(hospitalClinicRequest.getRequestedBloodType());
        requestHospitalClinicEntity.setRequestedBloodComponent(hospitalClinicRequest.getRequestedBloodComponent());
        requestHospitalClinicEntity.setRequestedQuantity(hospitalClinicRequest.getRequestedQuantity());
        requestHospitalClinicEntity.setNeedByDate(hospitalClinicRequest.getNeedByDate());
        requestHospitalClinicEntity.setRequestStatus(hospitalClinicRequest.getRequestStatus());
        requestHospitalClinicEntity.setObservation(hospitalClinicRequest.getObservation());
        this.requestHospitalClinicRepository.save(requestHospitalClinicEntity);
    }

    @Override
    public void deleteRequestHospitalClinic(Long id) {
        RequestHospitalClinicEntity requestHospitalClinicEntity = requestHospitalClinicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Clinic not found"));
        requestHospitalClinicRepository.delete(requestHospitalClinicEntity);
    }
}
