package blood.bank.domain.entities.questionOption;

import blood.bank.domain.entities.question.Question;

public class QuestionOption {

    private Long id;

    private Question question;

    private String text;

    public QuestionOption(Long id, Question question, String text) {
        this.id = id;
        this.question = question;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
