package blood.bank.domain.entities.question;

import blood.bank.domain.entities.questionary.Questionary;
import blood.bank.domain.enums.AnswerType;

public class Question {

    private Questionary questionary;

    private String text;

    private boolean obrigatoryAnswer;

    private AnswerType type;

    public Questionary getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Questionary questionary) {
        this.questionary = questionary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isObrigatoryAnswer() {
        return obrigatoryAnswer;
    }

    public void setObrigatoryAnswer(boolean obrigatoryAnswer) {
        this.obrigatoryAnswer = obrigatoryAnswer;
    }

    public AnswerType getType() {
        return type;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public Question(Questionary questionary, String text, boolean obrigatoryAnswer, AnswerType type) {
        this.questionary = questionary;
        this.text = text;
        this.obrigatoryAnswer = obrigatoryAnswer;
        this.type = type;
    }
}
