package blood.bank.domain.entities.challenge;

import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.persistence.models.RewardEntity;

import java.time.LocalDate;

public class Challenge {

    private Long id;

    private Reward reward;

    private String challengeName;

    private String description;

    private String criteria;

    private LocalDate startDate;

    private LocalDate endDate;

    public Challenge(Long id, Reward reward, String challengeName, String description, String criteria, LocalDate startDate, LocalDate endDate) {
        this.id = id;
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

    public String getChallengeName() {
        return challengeName;
    }

    public Reward getReward() {
        return reward;
    }

    public String getCriteria() {
        return criteria;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
