package blood.bank.infra.mappers;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.BadgeEntity;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DonorMapper {


    public static DonorEntity toEntity(Donor donor) {
        PeopleEntity peopleEntity = PeopleEntityMapper.toEntity(donor.getPeople());
        List<BadgeEntity> badgeEntities = donor.getBadge().stream()
                .map(BadgeEntityMapper::toEntity).toList();
        return new DonorEntity(peopleEntity, donor.getBloodType(), donor.getRegisterDate(),
                donor.getLastDonationDate(), donor.getNumberOfDonations(), donor.getEligibility(), donor.getMedicalNotes(), donor.getbCoinsBalance(),
                donor.getImage(), badgeEntities);
    }

    public static Donor toDonor(DonorEntity donorEntity){
        People people = PeopleEntityMapper.toPeople(donorEntity.getPeople());
        List<Badge> badges = donorEntity.getBadge().stream()
                .map(BadgeEntityMapper::toBadge).toList();
        return new Donor(people, donorEntity.getBloodType(), donorEntity.getRegisterDate(),
                donorEntity.getLastDonationDate(), donorEntity.getNumberOfDonations(), donorEntity.getEligibility(),
                donorEntity.getMedicalNotes(), donorEntity.getbCoinsBalance(), donorEntity.getImage(), badges
        );
    }
}
