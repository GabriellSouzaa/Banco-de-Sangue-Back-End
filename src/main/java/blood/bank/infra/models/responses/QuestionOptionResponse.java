package blood.bank.infra.models.responses;

import blood.bank.domain.entities.questionOption.QuestionOption;

public class QuestionOptionResponse {

    private Long id;

    private QuestionResponse question;

    private String text;

    public QuestionOptionResponse(QuestionOption questionOption){
        this.id = questionOption.getId();
        this.question = new QuestionResponse(questionOption.getQuestion());
        this.text = questionOption.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
