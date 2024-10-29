package blood.bank.application.gateways;

import blood.bank.domain.entities.request.Request;

import java.util.List;

public interface RequestRepositoryGateway {

    List<Request> getRequests();
}
