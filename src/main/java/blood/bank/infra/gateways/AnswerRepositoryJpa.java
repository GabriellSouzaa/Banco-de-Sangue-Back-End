package blood.bank.infra.gateways;

import blood.bank.application.gateways.AnswerRepositoryGateway;
import blood.bank.domain.entities.answer.Answer;
import blood.bank.infra.mappers.AnswerEntityMapper;
import blood.bank.infra.persistence.models.AnswerEntity;
import blood.bank.infra.persistence.repositories.AnswerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerRepositoryJpa  implements AnswerRepositoryGateway {

    private final AnswerRepository answerRepository;

    private final AnswerEntityMapper answerEntityMapper;

    public AnswerRepositoryJpa(AnswerRepository answerRepository, AnswerEntityMapper answerEntityMapper) {
        this.answerRepository = answerRepository;
        this.answerEntityMapper = answerEntityMapper;
    }

    @Override
    public List<Answer> listAnswersByDonorFullNameAndEmailAndQuestionText(String fullName, String email, String questionText) {
        List<AnswerEntity> answerEntities = answerRepository.findAnswerEntityByDonor_People_FullNameAndDonor_PeopleEmailAndQuestion_Text(fullName, email, questionText);
        return answerEntities.stream().map(AnswerEntityMapper::toAnswer).collect(Collectors.toList());
    }
}
