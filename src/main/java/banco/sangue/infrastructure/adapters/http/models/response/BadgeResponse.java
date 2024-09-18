package banco.sangue.infrastructure.adapters.http.models.response;

import banco.sangue.infrastructure.persistence.entities.BadgeEntity;

import java.time.LocalDate;

public record BadgeResponse(String badgeName, String image, Integer necessaryPoints, LocalDate dateOfAchievement) {

    public BadgeResponse(BadgeEntity badgeEntity){
        this(badgeEntity.getBadgeName(), badgeEntity.getImage(), badgeEntity.getNecessaryPoints(), badgeEntity.getDateOfAchievement());
    }
}
