package blood.bank.application.gateways;

import blood.bank.domain.entities.request.Request;
import blood.bank.infra.models.requests.RequestOpinionRequest;

import java.util.List;

public interface RequestRepositoryGateway {

    List<Request> getRequests();

    void sendRequestOpinion(RequestOpinionRequest requestOpinionRequest);
}
