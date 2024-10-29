package blood.bank.infra.persistence.models;

import blood.bank.domain.enums.AnswerType;
import jakarta.persistence.*;

@Entity
@Table(name = "pergunta")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionario_id")
    private QuestionaryEntity questionary;

    @Column(name = "texto")
    private String text;

    @Column(name = "resposta_obrigatoria")
    private boolean obrigatoryAnswer;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private AnswerType type;

    public QuestionEntity(Long id, QuestionaryEntity questionary, String text, boolean obrigatoryAnswer, AnswerType type) {
        this.id = id;
        this.questionary = questionary;
        this.text = text;
        this.obrigatoryAnswer = obrigatoryAnswer;
        this.type = type;
    }

    public QuestionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionaryEntity getQuestionary() {
        return questionary;
    }

    public void setQuestionary(QuestionaryEntity questionary) {
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
