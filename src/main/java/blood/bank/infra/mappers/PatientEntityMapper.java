package blood.bank.infra.mappers;

import blood.bank.domain.entities.patient.Patient;
import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.PatientEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

public class PatientEntityMapper {

    public static PatientEntity toEntity(Patient patient){
        PeopleEntity peopleEntity = PeopleEntityMapper.toEntity(patient.getPeople());
        return new PatientEntity(peopleEntity, patient.getCpf(), patient.getPhone(), patient.getBloodType(), patient.getMedicalHistory(), patient.getHealthPlanNumber(), patient.getObservations());
    }

    public static Patient toPatient(PatientEntity peopleEntity){
        People people = PeopleEntityMapper.toPeople(peopleEntity.getPeople());
        return new Patient(people, peopleEntity.getCpf(), peopleEntity.getPhone(), peopleEntity.getBloodType(), peopleEntity.getMedicalHistory(), peopleEntity.getHealthPlanNumber(), peopleEntity.getObservations());
    }
}
