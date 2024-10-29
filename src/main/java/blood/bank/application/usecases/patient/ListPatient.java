package blood.bank.application.usecases.patient;

import blood.bank.application.gateways.PatientRepositoryGateway;
import blood.bank.domain.entities.patient.Patient;

import java.util.List;

public class ListPatient {

    private final PatientRepositoryGateway patientRepositoryGateway;

    public ListPatient(PatientRepositoryGateway patientRepositoryGateway) {
        this.patientRepositoryGateway = patientRepositoryGateway;
    }

    public List<Patient> getAllPatients() {
        return patientRepositoryGateway.getPatients();
    }
}
