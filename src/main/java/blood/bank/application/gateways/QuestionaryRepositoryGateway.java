package blood.bank.application.gateways;

import blood.bank.domain.entities.questionary.Questionary;

import java.util.List;

public interface QuestionaryRepositoryGateway {

    List<Questionary> getQuestionaries();
}
