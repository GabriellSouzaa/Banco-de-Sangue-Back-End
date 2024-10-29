package blood.bank.application.usecases.request;

import blood.bank.application.gateways.RequestRepositoryGateway;
import blood.bank.domain.entities.request.Request;

import java.util.List;

public class ListRequests {

    private final RequestRepositoryGateway requestRepositoryGateway;

    public ListRequests(RequestRepositoryGateway requestRepositoryGateway) {
        this.requestRepositoryGateway = requestRepositoryGateway;
    }

    public List<Request> getRequests(){
        return requestRepositoryGateway.getRequests();
    }
}
