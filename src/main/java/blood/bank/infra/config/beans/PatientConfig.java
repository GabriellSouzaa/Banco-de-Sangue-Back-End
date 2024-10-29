package blood.bank.infra.config.beans;

import blood.bank.application.gateways.PatientRepositoryGateway;
import blood.bank.application.usecases.patient.ListPatient;
import blood.bank.infra.gateways.PatientRepositoryJpa;
import blood.bank.infra.mappers.PatientEntityMapper;
import blood.bank.infra.persistence.repositories.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {

    @Bean
    PatientEntityMapper patientEntityMapper() {
        return new PatientEntityMapper();
    }

    @Bean
    PatientRepositoryJpa patientRepositoryJpa(PatientRepository patientRepository, PatientEntityMapper patientEntityMapper) {
        return new PatientRepositoryJpa(patientRepository, patientEntityMapper);
    }

    @Bean
    ListPatient listPatient(PatientRepositoryGateway patientRepositoryGateway){
        return new ListPatient(patientRepositoryGateway);
    }
}
