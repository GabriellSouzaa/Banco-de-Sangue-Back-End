package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doador_id")
    private DonorEntity donor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pergunta_id")
    private QuestionEntity question;

    @Column(name = "resposta")
    @JoinColumn(name = "resposta")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "opcao_id")
    private QuestionOptionEntity option;

    public AnswerEntity(Long id, DonorEntity donor, QuestionEntity question, String answer, QuestionOptionEntity option) {
        this.id = id;
        this.donor = donor;
        this.question = question;
        this.answer = answer;
        this.option = option;
    }

    public AnswerEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
        this.donor = donor;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionOptionEntity getOption() {
        return option;
    }

    public void setOption(QuestionOptionEntity option) {
        this.option = option;
    }
}
