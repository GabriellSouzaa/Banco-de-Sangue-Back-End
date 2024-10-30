package blood.bank.application.usecases.request;

import blood.bank.application.gateways.RequestRepositoryGateway;
import blood.bank.infra.models.requests.RequestOpinionRequest;

public class SendRequestOpinion {

    private final RequestRepositoryGateway requestRepositoryGateway;

    public SendRequestOpinion(RequestRepositoryGateway requestRepositoryGateway) {
        this.requestRepositoryGateway = requestRepositoryGateway;
    }

    public void sendRequestOpinion(RequestOpinionRequest requestOpinionRequest){
        requestRepositoryGateway.sendRequestOpinion(requestOpinionRequest);
    }
}
