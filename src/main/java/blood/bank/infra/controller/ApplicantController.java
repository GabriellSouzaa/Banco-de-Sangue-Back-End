package blood.bank.infra.controller;

import blood.bank.application.usecases.applicant.ListApplicant;
import blood.bank.domain.entities.applicant.Applicant;
import blood.bank.infra.models.responses.ApplicantResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ListApplicant listApplicant;

    public ApplicantController(ListApplicant listApplicant) {
        this.listApplicant = listApplicant;
    }

    @GetMapping
    List<ApplicantResponse> listApplicants(){
        List<Applicant> applicants = listApplicant.getApplicants();
        return applicants.stream().map(ApplicantResponse::new).collect(Collectors.toList());
    }
}
