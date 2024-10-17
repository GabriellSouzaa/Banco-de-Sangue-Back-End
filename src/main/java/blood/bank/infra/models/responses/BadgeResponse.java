package blood.bank.infra.models.responses;

import blood.bank.domain.entities.badge.Badge;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class BadgeResponse {

    private String badgeName;

    private String image;

    private Integer necessaryPoints;

    private LocalDate dateOfAchievement;

    public BadgeResponse(Badge badge) {

        this.badgeName = badge.getBadgeName();
        this.image = badge.getImage();
        this.necessaryPoints = badge.getNecessaryPoints();
        this.dateOfAchievement = badge.getDateOfAchievement();
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public Integer getNecessaryPoints() {
        return necessaryPoints;
    }

    public void setNecessaryPoints(Integer necessaryPoints) {
        this.necessaryPoints = necessaryPoints;
    }

    public LocalDate getDateOfAchievement() {
        return dateOfAchievement;
    }

    public void setDateOfAchievement(LocalDate dateOfAchievement) {
        this.dateOfAchievement = dateOfAchievement;
    }
}
