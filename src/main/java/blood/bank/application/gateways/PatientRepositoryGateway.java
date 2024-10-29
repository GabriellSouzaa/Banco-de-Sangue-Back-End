package blood.bank.application.gateways;

import blood.bank.domain.entities.patient.Patient;

import java.util.List;

public interface PatientRepositoryGateway {

    List<Patient> getPatients();
}
