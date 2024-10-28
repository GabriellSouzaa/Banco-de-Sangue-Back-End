package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "opcao_pergunta")
public class QuestionOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pergunta_id")
    private QuestionEntity question;

    @Column(name = "texto")
    private String text;

    public QuestionOptionEntity(QuestionEntity question, String text) {
        this.question = question;
        this.text = text;
    }

    public QuestionOptionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
