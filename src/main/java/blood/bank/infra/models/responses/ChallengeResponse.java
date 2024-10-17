package blood.bank.infra.models.responses;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.reward.Reward;

import java.time.LocalDate;

public class ChallengeResponse {

    private Reward reward;

    private String challengeName;

    private String description;

    private String criteria;

    private LocalDate startDate;

    private LocalDate endDate;

    public ChallengeResponse(Challenge challenge) {
        this.reward = challenge.getReward();
        this.challengeName = challenge.getChallengeName();
        this.description = challenge.getDescription();
        this.criteria = challenge.getCriteria();
        this.startDate = challenge.getStartDate();
        this.endDate = challenge.getEndDate();
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
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
