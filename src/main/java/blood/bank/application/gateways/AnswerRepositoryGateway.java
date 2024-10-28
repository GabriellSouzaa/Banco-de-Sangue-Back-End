package blood.bank.application.gateways;

import blood.bank.domain.entities.answer.Answer;

import java.util.List;

public interface AnswerRepositoryGateway {

    List<Answer> listAnswersByDonorFullNameAndEmailAndQuestionText(String fullName, String email, String questionText);
}
