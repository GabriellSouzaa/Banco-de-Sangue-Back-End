package blood.bank.infra.mappers;

import blood.bank.domain.entities.questionary.Questionary;
import blood.bank.infra.persistence.models.QuestionaryEntity;

public class QuestionaryEntityMapper {

    public static QuestionaryEntity toEntity(Questionary questionary){
        return new QuestionaryEntity(questionary.getName(), questionary.getDescription());
    }

    public static Questionary toQuestionary(QuestionaryEntity questionaryEntity){
        return new Questionary(questionaryEntity.getName(), questionaryEntity.getDescription());
    }
}
