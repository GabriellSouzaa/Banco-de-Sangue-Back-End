package blood.bank.infra.mappers;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

public class DonorMapper {


    public static DonorEntity toEntity(Donor donor) {
        PeopleEntity peopleEntity = PeopleEntityMapper.toEntity(donor.getPeople());
        return new DonorEntity(donor.getId(), peopleEntity, donor.getBloodType(), donor.getRegisterDate(),
                donor.getLastDonationDate(), donor.getNumberOfDonations(), donor.getEligibility(), donor.getMedicalNotes(), donor.getbCoinsBalance(),
                donor.getImage());
    }

    public static Donor toDonor(DonorEntity donorEntity){
        People people = PeopleEntityMapper.toPeople(donorEntity.getPeople());
        return new Donor(donorEntity.getId(), people, donorEntity.getBloodType(), donorEntity.getRegisterDate(),
                donorEntity.getLastDonationDate(), donorEntity.getNumberOfDonations(), donorEntity.getEligibility(), donorEntity.getMedicalNotes(), donorEntity.getbCoinsBalance(),
                donorEntity.getImage());
    }
}
