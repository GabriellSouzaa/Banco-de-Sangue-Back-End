package blood.bank.domain.entities.badge;

import java.time.LocalDate;

public class Badge {


    private String badgeName;

    private String image;

    private Integer necessaryPoints;


    private LocalDate dateOfAchievement;


    public Badge(String badgeName, String image, Integer necessaryPoints, LocalDate dateOfAchievement) {
        this.badgeName = badgeName;
        this.image = image;
        this.necessaryPoints = necessaryPoints;
        this.dateOfAchievement = dateOfAchievement;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
