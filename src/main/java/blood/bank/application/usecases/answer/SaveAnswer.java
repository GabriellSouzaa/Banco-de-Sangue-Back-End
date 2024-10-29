package blood.bank.application.usecases.answer;

import blood.bank.application.gateways.AnswerRepositoryGateway;
import blood.bank.infra.models.requests.AnswerRequest;

public class SaveAnswer {

    private final AnswerRepositoryGateway answerRepositoryGateway;

    public SaveAnswer(AnswerRepositoryGateway answerRepositoryGateway) {
        this.answerRepositoryGateway = answerRepositoryGateway;
    }

    public void saveAnswer(AnswerRequest answerRequest) {
        answerRepositoryGateway.saveAnswer(answerRequest);
    }
}
