package blood.bank.domain.entities.questionOption;

import blood.bank.domain.entities.question.Question;

public class QuestionOption {

    private Question question;

    private String text;

    public QuestionOption(Question question, String text) {
        this.question = question;
        this.text = text;
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
