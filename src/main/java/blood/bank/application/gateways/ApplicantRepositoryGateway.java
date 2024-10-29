package blood.bank.application.gateways;

import blood.bank.domain.entities.applicant.Applicant;

import java.util.List;

public interface ApplicantRepositoryGateway {

    List<Applicant> getApplicants();
}
