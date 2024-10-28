package blood.bank.infra.gateways;

import blood.bank.application.gateways.QuestionRepositoryGateway;
import blood.bank.domain.entities.question.Question;
import blood.bank.infra.mappers.QuestionEntityMapper;
import blood.bank.infra.persistence.models.QuestionEntity;
import blood.bank.infra.persistence.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionRepositoryJpa implements QuestionRepositoryGateway {

    private final QuestionRepository questionRepository;

    private final QuestionEntityMapper questionEntityMapper;

    public QuestionRepositoryJpa(QuestionRepository questionRepository, QuestionEntityMapper questionEntityMapper) {
        this.questionRepository = questionRepository;
        this.questionEntityMapper = questionEntityMapper;
    }

    @Override
    public List<Question> getQuestionsByQuestionaryName(String questionaryName) {
        List<QuestionEntity> questions = questionRepository.findAllByQuestionary_Name(questionaryName);
        return questions.stream().map(QuestionEntityMapper::toQuestion).collect(Collectors.toList());
    }
}
