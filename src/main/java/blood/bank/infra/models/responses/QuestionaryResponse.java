package blood.bank.infra.models.responses;

import blood.bank.domain.entities.questionary.Questionary;

public class QuestionaryResponse {

    private String name;

    private String description;

    public QuestionaryResponse(Questionary questionary) {
        this.name = questionary.getName();
        this.description = questionary.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
