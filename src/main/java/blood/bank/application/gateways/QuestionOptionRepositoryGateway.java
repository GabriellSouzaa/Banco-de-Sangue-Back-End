package blood.bank.application.gateways;

import blood.bank.domain.entities.questionOption.QuestionOption;

import java.util.List;

public interface QuestionOptionRepositoryGateway {

    List<QuestionOption> getQuestionOptionsByQuestionName(String questionName);
}
