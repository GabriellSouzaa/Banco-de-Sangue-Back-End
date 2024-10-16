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
    private RewardEntity reward;


    private String challengeName;

    private String description;

    private String criteria;

    private LocalDate startDate;

    private LocalDate endDate;

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
