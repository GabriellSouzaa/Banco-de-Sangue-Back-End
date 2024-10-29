package blood.bank.infra.gateways;

import blood.bank.application.gateways.ApplicantRepositoryGateway;
import blood.bank.domain.entities.applicant.Applicant;
import blood.bank.infra.mappers.ApplicantMapper;
import blood.bank.infra.persistence.models.ApplicantEntity;
import blood.bank.infra.persistence.repositories.ApplicantRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicantRepositoryJpa implements ApplicantRepositoryGateway {

    private final ApplicantRepository applicantRepository;

    public ApplicantRepositoryJpa(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @Override
    public List<Applicant> getApplicants() {
        List<ApplicantEntity> applicants = applicantRepository.findAll();
        return applicants.stream().map(ApplicantMapper::toApplicant).collect(Collectors.toList());
    }
}
