package blood.bank.infra.gateways;

import blood.bank.application.gateways.QuestionaryRepositoryGateway;
import blood.bank.domain.entities.questionary.Questionary;
import blood.bank.infra.mappers.QuestionaryEntityMapper;
import blood.bank.infra.persistence.models.QuestionaryEntity;
import blood.bank.infra.persistence.repositories.QuestionaryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionaryRepositoryJpa implements QuestionaryRepositoryGateway {

    private final QuestionaryRepository questionaryRepository;

    private final QuestionaryEntityMapper questionaryEntityMapper;

    public QuestionaryRepositoryJpa(QuestionaryRepository questionaryRepository, QuestionaryEntityMapper questionaryEntityMapper) {
        this.questionaryRepository = questionaryRepository;
        this.questionaryEntityMapper = questionaryEntityMapper;
    }

    @Override
    public List<Questionary> getQuestionaries() {
        List<QuestionaryEntity> questionaryEntities = questionaryRepository.findAll();
        return questionaryEntities.stream().map(QuestionaryEntityMapper::toQuestionary).collect(Collectors.toList());
    }
}
