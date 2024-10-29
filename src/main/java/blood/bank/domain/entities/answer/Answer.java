package blood.bank.domain.entities.answer;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.question.Question;
import blood.bank.domain.entities.questionOption.QuestionOption;

public class Answer {

    private Long id;

    private Donor donor;

    private Question question;

    private String answer;

    private QuestionOption option;

    public Answer(Long id, Donor donor, Question question, String answer, QuestionOption option) {
        this.id = id;
        this.donor = donor;
        this.question = question;
        this.answer = answer;
        this.option = option;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionOption getOption() {
        return option;
    }

    public void setOption(QuestionOption option) {
        this.option = option;
    }
}
