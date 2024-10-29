package blood.bank.application.usecases.applicant;

import blood.bank.application.gateways.ApplicantRepositoryGateway;
import blood.bank.domain.entities.applicant.Applicant;

import java.util.List;

public class ListApplicant {

    private final ApplicantRepositoryGateway applicantRepositoryGateway;

    public ListApplicant(ApplicantRepositoryGateway applicantRepositoryGateway) {
        this.applicantRepositoryGateway = applicantRepositoryGateway;
    }

    public List<Applicant> getApplicants() {
        return applicantRepositoryGateway.getApplicants();
    }
}
