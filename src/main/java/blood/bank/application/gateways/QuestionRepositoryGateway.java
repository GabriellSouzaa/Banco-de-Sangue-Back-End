package blood.bank.application.gateways;

import blood.bank.domain.entities.question.Question;

import java.util.List;

public interface QuestionRepositoryGateway {

    List<Question> getQuestionsByQuestionaryName(String questionaryName);
}
