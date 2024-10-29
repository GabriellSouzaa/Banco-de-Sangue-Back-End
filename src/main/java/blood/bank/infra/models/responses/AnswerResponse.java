package blood.bank.infra.models.responses;

import blood.bank.domain.entities.answer.Answer;

public class AnswerResponse {

    private Long id;

    private DonorResponse donor;

    private QuestionResponse question;

    private String answer;

    private QuestionOptionResponse option;

    public AnswerResponse(Answer answer){
        this.id = answer.getId();
        this.donor = new DonorResponse(answer.getDonor());
        this.question = new QuestionResponse(answer.getQuestion());
        this.answer = answer.getAnswer();
        this.option = new QuestionOptionResponse(answer.getOption());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
        this.donor = donor;
    }

    public QuestionResponse getQuestion() {
        return question;
    }

    public void setQuestion(QuestionResponse question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionOptionResponse getOption() {
        return option;
    }

    public void setOption(QuestionOptionResponse option) {
        this.option = option;
    }
}
