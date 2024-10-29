package blood.bank.infra.mappers;

import blood.bank.domain.entities.applicant.Applicant;
import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.ApplicantEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

public class ApplicantMapper {

    public static ApplicantEntity toEntity(Applicant applicant) {
        PeopleEntity peopleEntity = PeopleEntityMapper.toEntity(applicant.getPeople());
        return new ApplicantEntity(peopleEntity);
    }

    public static Applicant toApplicant(ApplicantEntity entity) {
        People people = PeopleEntityMapper.toPeople(entity.getPeople());
        return new Applicant(people);
    }
}
