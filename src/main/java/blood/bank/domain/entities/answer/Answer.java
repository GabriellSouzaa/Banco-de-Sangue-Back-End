package blood.bank.domain.entities.answer;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.question.Question;
import blood.bank.domain.entities.questionOption.QuestionOption;

public class Answer {

    private Donor donor;

    private Question question;

    private String answer;

    private QuestionOption option;

    public Answer(Donor donor, Question question, String answer, QuestionOption option) {
        this.donor = donor;
        this.question = question;
        this.answer = answer;
        this.option = option;
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
