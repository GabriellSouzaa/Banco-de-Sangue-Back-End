package blood.bank.infra.mappers;

import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.PeopleEntity;

public class PeopleEntityMapper {

    public static PeopleEntity toEntity(People people) {
        return new PeopleEntity(people.getFullName(), people.getDateOfBirth(), people.getGender(), people.getEmail());
    }

    public static People toPeople(PeopleEntity peopleEntity) {
        return new People(peopleEntity.getFullName(), peopleEntity.getDateOfBirth(), peopleEntity.getGender(), peopleEntity.getEmail());
    }
}
