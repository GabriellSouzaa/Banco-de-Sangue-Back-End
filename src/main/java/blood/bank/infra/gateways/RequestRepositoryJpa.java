package blood.bank.infra.gateways;

import blood.bank.application.gateways.RequestRepositoryGateway;
import blood.bank.domain.entities.request.Request;
import blood.bank.infra.mappers.RequestEntityMapper;
import blood.bank.infra.models.requests.RequestOpinionRequest;
import blood.bank.infra.persistence.models.RequestEntity;
import blood.bank.infra.persistence.repositories.RequestRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RequestRepositoryJpa implements RequestRepositoryGateway {

    private final RequestRepository requestRepository;

    private final RequestEntityMapper requestEntityMapper;

    public RequestRepositoryJpa(RequestRepository requestRepository, RequestEntityMapper requestEntityMapper) {
        this.requestRepository = requestRepository;
        this.requestEntityMapper = requestEntityMapper;
    }

    @Override
    public List<Request> getRequests() {
        List<RequestEntity> requests = requestRepository.findAll();
        return requests.stream().map(RequestEntityMapper::toRequest).collect(Collectors.toList());
    }

    @Override
    public void sendRequestOpinion(RequestOpinionRequest requestOpinionRequest) {
        RequestEntity requestEntity = requestRepository.findRequestEntityByPatientCpfAndRequestDate(requestOpinionRequest.getPatientCpf(), requestOpinionRequest.getRequestDate());
        requestEntity.setOpinion(requestOpinionRequest.getOpinion());
        requestRepository.save(requestEntity);
    }
}
