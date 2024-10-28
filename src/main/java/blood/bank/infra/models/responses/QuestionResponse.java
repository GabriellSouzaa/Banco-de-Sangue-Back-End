package blood.bank.infra.models.responses;

import blood.bank.domain.entities.question.Question;
import blood.bank.domain.enums.AnswerType;

public class QuestionResponse {

    private QuestionaryResponse questionary;

    private String text;

    private boolean obrigatoryAnswer;

    private AnswerType type;

    public QuestionResponse(Question question){
        this.questionary = new QuestionaryResponse(question.getQuestionary());
        this.text = question.getText();
        this.obrigatoryAnswer = question.isObrigatoryAnswer();
        this.type = question.getType();
    }

    public QuestionaryResponse getQuestionary() {
        return questionary;
    }

    public void setQuestionary(QuestionaryResponse questionary) {
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
}
