package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "desafio")
public class ChallengeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_desafio")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recompensa_id_recompensa")
    private RewardEntity reward;

    @Column(name = "nome_desafio")
    private String challengeName;

    @Column(name = "descricao")
    private String description;

    @Column(name = "criterios")
    private String criteria;

    @Column(name = "data_inicio")
    private LocalDate startDate;

    @Column(name = "data_termino")
    private LocalDate endDate;

    public ChallengeEntity() {
    }

    public ChallengeEntity(RewardEntity reward, String challengeName, String description, String criteria, LocalDate startDate, LocalDate endDate) {
        this.reward = reward;
        this.challengeName = challengeName;
        this.description = description;
        this.criteria = criteria;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RewardEntity getReward() {
        return reward;
    }

    public void setReward(RewardEntity reward) {
        this.reward = reward;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
