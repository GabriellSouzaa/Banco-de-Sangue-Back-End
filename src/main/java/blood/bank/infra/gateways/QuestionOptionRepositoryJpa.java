package blood.bank.infra.gateways;

import blood.bank.application.gateways.QuestionOptionRepositoryGateway;
import blood.bank.domain.entities.questionOption.QuestionOption;
import blood.bank.infra.mappers.QuestionOptionEntityMapper;
import blood.bank.infra.persistence.models.QuestionOptionEntity;
import blood.bank.infra.persistence.repositories.QuestionOptionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionOptionRepositoryJpa implements QuestionOptionRepositoryGateway {

    private final QuestionOptionRepository questionOptionRepository;

    private final QuestionOptionEntityMapper questionOptionEntityMapper;

    public QuestionOptionRepositoryJpa(QuestionOptionRepository questionOptionRepository, QuestionOptionEntityMapper questionOptionEntityMapper) {
        this.questionOptionRepository = questionOptionRepository;
        this.questionOptionEntityMapper = questionOptionEntityMapper;
    }

    @Override
    public List<QuestionOption> getQuestionOptionsByQuestionName(String questionName) {
        List<QuestionOptionEntity> questionOptionEntities = questionOptionRepository.findAllByQuestion_Text(questionName);
        return questionOptionEntities.stream().map(QuestionOptionEntityMapper::toQuestionOption).collect(Collectors.toList());
    }
}
