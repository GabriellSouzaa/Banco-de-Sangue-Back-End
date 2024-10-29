package blood.bank.infra.gateways;

import blood.bank.application.gateways.PatientRepositoryGateway;
import blood.bank.domain.entities.patient.Patient;
import blood.bank.infra.mappers.PatientEntityMapper;
import blood.bank.infra.persistence.models.PatientEntity;
import blood.bank.infra.persistence.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PatientRepositoryJpa implements PatientRepositoryGateway {

    private final PatientRepository patientRepository;

    private final PatientEntityMapper patientEntityMapper;

    public PatientRepositoryJpa(PatientRepository patientRepository, PatientEntityMapper patientEntityMapper) {
        this.patientRepository = patientRepository;
        this.patientEntityMapper = patientEntityMapper;
    }

    @Override
    public List<Patient> getPatients() {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream().map(PatientEntityMapper::toPatient).collect(Collectors.toList());
    }
}
