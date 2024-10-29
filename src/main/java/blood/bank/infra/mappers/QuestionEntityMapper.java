package blood.bank.infra.mappers;

import blood.bank.domain.entities.question.Question;
import blood.bank.domain.entities.questionary.Questionary;
import blood.bank.infra.persistence.models.QuestionEntity;
import blood.bank.infra.persistence.models.QuestionaryEntity;

public class QuestionEntityMapper {

    public static QuestionEntity toEntity(Question question) {
        QuestionaryEntity questionaryEntity = QuestionaryEntityMapper.toEntity(question.getQuestionary());
        return new QuestionEntity(question.getId(), questionaryEntity, question.getText(), question.isObrigatoryAnswer(), question.getType());
    }

    public static Question toQuestion(QuestionEntity questionEntity) {
        Questionary questionary = QuestionaryEntityMapper.toQuestionary(questionEntity.getQuestionary());
        return new Question(questionEntity.getId(), questionary, questionEntity.getText(), questionEntity.isObrigatoryAnswer(), questionEntity.getType());
    }
}
