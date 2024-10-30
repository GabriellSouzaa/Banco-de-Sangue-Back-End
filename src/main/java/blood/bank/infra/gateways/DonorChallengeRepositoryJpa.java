package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorChallengeRepositoryGateway;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.mappers.DonorChallengeEntityMapper;
import blood.bank.infra.models.requests.GrantDonorChallengeRequest;
import blood.bank.infra.persistence.models.ChallengeEntity;
import blood.bank.infra.persistence.models.DonorChallengeEntity;
import blood.bank.infra.persistence.models.DonorChallengeId;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.repositories.ChallengeRepository;
import blood.bank.infra.persistence.repositories.DonorChallengeRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonorChallengeRepositoryJpa implements DonorChallengeRepositoryGateway {

    private final DonorChallengeRepository donorChallengeRepository;

    private final DonorChallengeEntityMapper donorChallengeEntityMapper;

    private final DonorRepository donorRepository;

    private final ChallengeRepository challengeRepository;

    public DonorChallengeRepositoryJpa(DonorChallengeRepository donorChallengeRepository, DonorChallengeEntityMapper donorChallengeEntityMapper, DonorRepository donorRepository, ChallengeRepository challengeRepository) {
        this.donorChallengeRepository = donorChallengeRepository;
        this.donorChallengeEntityMapper = donorChallengeEntityMapper;
        this.donorRepository = donorRepository;
        this.challengeRepository = challengeRepository;
    }

    @Override
    public List<DonorChallenge> getDonorChallengeByDonorFullNameAndEmail(String donorName, String email) {
        List<DonorChallengeEntity> donorChallengeEntities = this.donorChallengeRepository.findAllByDonor_People_FullNameAndDonor_People_Email(donorName, email);
        return donorChallengeEntities.stream().map(DonorChallengeEntityMapper::toDonorChallenge).collect(Collectors.toList());
    }

    @Override
    public void grantDonorChallenge(GrantDonorChallengeRequest grantDonorChallengeRequest) {
        DonorChallengeEntity donorChallengeEntity = new DonorChallengeEntity();

        DonorEntity donor = donorRepository.findById(grantDonorChallengeRequest.getDonorId())
                .orElseThrow(() -> new IllegalArgumentException("Doador não encontrado"));

        ChallengeEntity challenge = challengeRepository.findById(grantDonorChallengeRequest.getChallengeId())
                .orElseThrow(() -> new IllegalArgumentException("Desafio não encontrado"));

        DonorChallengeId donorChallengeId = new DonorChallengeId(donor.getId(), challenge.getId());

        donorChallengeEntity.setId(donorChallengeId);
        donorChallengeEntity.setDonor(donor);
        donorChallengeEntity.setChallenge(challenge);

        donorChallengeRepository.save(donorChallengeEntity);
    }
}
