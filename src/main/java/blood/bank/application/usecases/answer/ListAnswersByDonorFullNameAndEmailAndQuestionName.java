package blood.bank.application.usecases.answer;

import blood.bank.application.gateways.AnswerRepositoryGateway;
import blood.bank.domain.entities.answer.Answer;

import java.util.List;

public class ListAnswersByDonorFullNameAndEmailAndQuestionName {

    private final AnswerRepositoryGateway answerRepositoryGateway;

    public ListAnswersByDonorFullNameAndEmailAndQuestionName(AnswerRepositoryGateway answerRepositoryGateway) {
        this.answerRepositoryGateway = answerRepositoryGateway;
    }

    public List<Answer> getAnswersByDonorFullNameAndEmailAndQuestionName(String fullName, String email, String questionText) {
        return answerRepositoryGateway.listAnswersByDonorFullNameAndEmailAndQuestionText(fullName, email, questionText);
    }
}
