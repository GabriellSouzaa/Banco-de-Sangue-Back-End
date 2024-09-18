package banco.sangue.infrastructure.adapters.http.models.request;

import banco.sangue.infrastructure.persistence.entities.BadgeEntity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BadgeRequest {

    private String badgeName;

    private String image;

    private Integer necessaryPoints;

    private LocalDate dateOfAchievement;

    public BadgeEntity convert(BadgeEntity badgeEntity) {
        badgeEntity.setBadgeName(this.badgeName);
        badgeEntity.setImage(this.image);
        badgeEntity.setNecessaryPoints(this.necessaryPoints);
        badgeEntity.setDateOfAchievement(this.dateOfAchievement);
        return badgeEntity;
    }
}
