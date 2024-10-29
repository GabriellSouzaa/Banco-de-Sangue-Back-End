package blood.bank.infra.models.requests;

public class AnswerRequest {
    private Long doadorId;

    private Long perguntaId;

    private Long opcaoId;

    private String respostaDissertativa;

    public Long getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Long doadorId) {
        this.doadorId = doadorId;
    }

    public Long getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Long perguntaId) {
        this.perguntaId = perguntaId;
    }

    public Long getOpcaoId() {
        return opcaoId;
    }

    public void setOpcaoId(Long opcaoId) {
        this.opcaoId = opcaoId;
    }

    public String getRespostaDissertativa() {
        return respostaDissertativa;
    }

    public void setRespostaDissertativa(String respostaDissertativa) {
        this.respostaDissertativa = respostaDissertativa;
    }
}
