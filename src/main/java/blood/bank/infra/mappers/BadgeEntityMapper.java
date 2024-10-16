package blood.bank.infra.mappers;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.infra.persistence.models.BadgeEntity;

public class BadgeEntityMapper {

    public static BadgeEntity toEntity(Badge badge) {
        return new BadgeEntity(badge.getBadgeName(), badge.getImage(), badge.getNecessaryPoints(), badge.getDateOfAchievement());
    }

    public static Badge toBadge(BadgeEntity badgeEntity) {
        return new Badge(badgeEntity.getBadgeName(), badgeEntity.getImage(), badgeEntity.getNecessaryPoints(), badgeEntity.getDateOfAchievement());
    }
}
