package blood.bank.application.usecases.questionOption;

import blood.bank.application.gateways.QuestionOptionRepositoryGateway;
import blood.bank.domain.entities.questionOption.QuestionOption;

import java.util.List;

public class ListQuestionsOptionsByQuestionName {

    private final QuestionOptionRepositoryGateway questionOptionRepositoryGateway;

    public ListQuestionsOptionsByQuestionName(QuestionOptionRepositoryGateway questionOptionRepositoryGateway) {
        this.questionOptionRepositoryGateway = questionOptionRepositoryGateway;
    }

    public List<QuestionOption> getQuestionsOptionsByQuestionName(String questionName) {
        return questionOptionRepositoryGateway.getQuestionOptionsByQuestionName(questionName);
    }
}
