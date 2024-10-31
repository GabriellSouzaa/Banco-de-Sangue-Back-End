package blood.bank.infra.mappers;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.persistence.models.BadgeEntity;
import blood.bank.infra.persistence.models.DonorBadgeEntity;
import blood.bank.infra.persistence.models.DonorEntity;

public class DonorBadgeEntityMapper {

    public static DonorBadgeEntity toEntity(DonorBadge donorBadge){
        DonorEntity donorEntity = new DonorEntity();
        BadgeEntity badgeEntity = new BadgeEntity();
        return new DonorBadgeEntity(donorEntity, badgeEntity, donorBadge.getAchievementDate());
    }

    public static DonorBadge toDonorBadgeEntity(DonorBadgeEntity donorBadge){
        Donor donor = DonorMapper.toDonor(donorBadge.getDonor());
        Badge badge = BadgeEntityMapper.toBadge(donorBadge.getBadgeEntity());
        return new DonorBadge(donor, badge, donorBadge.getAchievementDate());
    }
}
