package blood.bank.infra.mappers;

import blood.bank.domain.entities.question.Question;
import blood.bank.domain.entities.questionOption.QuestionOption;
import blood.bank.infra.persistence.models.QuestionEntity;
import blood.bank.infra.persistence.models.QuestionOptionEntity;

public class QuestionOptionEntityMapper {

    public static QuestionOptionEntity toEntity(QuestionOption questionOption){
        QuestionEntity questionEntity = QuestionEntityMapper.toEntity(questionOption.getQuestion());
        return new QuestionOptionEntity(questionOption.getId(), questionEntity, questionOption.getText());
    }

    public static QuestionOption toQuestionOption(QuestionOptionEntity questionOptionEntity){
        Question question = QuestionEntityMapper.toQuestion(questionOptionEntity.getQuestion());
        return new QuestionOption(questionOptionEntity.getId(), question, questionOptionEntity.getText());
    }
}
