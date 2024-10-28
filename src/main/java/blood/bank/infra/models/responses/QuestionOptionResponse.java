package blood.bank.infra.models.responses;

import blood.bank.domain.entities.questionOption.QuestionOption;

public class QuestionOptionResponse {

    private QuestionResponse question;

    private String text;

    public QuestionOptionResponse(QuestionOption questionOption){
        this.question = new QuestionResponse(questionOption.getQuestion());
        this.text = questionOption.getText();
    }

    public QuestionResponse getQuestion() {
        return question;
    }

    public void setQuestion(QuestionResponse question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
