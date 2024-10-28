package blood.bank.application.usecases.question;

import blood.bank.application.gateways.QuestionRepositoryGateway;
import blood.bank.domain.entities.question.Question;

import java.util.List;

public class ListQuestionsByQuestionaryName {

    private final QuestionRepositoryGateway questionRepositoryGateway;

    public ListQuestionsByQuestionaryName(QuestionRepositoryGateway questionRepositoryGateway) {
        this.questionRepositoryGateway = questionRepositoryGateway;
    }

    public List<Question> getQuestionsByQuestionaryName(String questionaryName) {
        return questionRepositoryGateway.getQuestionsByQuestionaryName(questionaryName);
    }
}
