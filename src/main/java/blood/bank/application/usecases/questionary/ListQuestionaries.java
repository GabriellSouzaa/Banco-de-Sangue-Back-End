package blood.bank.application.usecases.questionary;

import blood.bank.application.gateways.QuestionaryRepositoryGateway;
import blood.bank.domain.entities.questionary.Questionary;

import java.util.List;

public class ListQuestionaries {

    private final QuestionaryRepositoryGateway questionaryRepositoryGateway;

    public ListQuestionaries(QuestionaryRepositoryGateway questionaryRepositoryGateway) {
        this.questionaryRepositoryGateway = questionaryRepositoryGateway;
    }

    public List<Questionary> getAllQuestionaries() {
        return  questionaryRepositoryGateway.getQuestionaries();
    }
}
