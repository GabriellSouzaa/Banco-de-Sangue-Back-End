package blood.bank.infra.controller;

import blood.bank.application.usecases.patient.ListPatient;
import blood.bank.domain.entities.patient.Patient;
import blood.bank.infra.models.responses.PatientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final ListPatient listPatient;

    public PatientController(ListPatient listPatient){
        this.listPatient = listPatient;
    }

    @GetMapping
    List<PatientResponse> patients(){
        List<Patient> patients = listPatient.getAllPatients();
        return patients.stream().map(PatientResponse::new).collect(Collectors.toList());
    }
}
