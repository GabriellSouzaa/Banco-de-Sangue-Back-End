package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorChallengeRepositoryGateway;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.mappers.DonorChallengeEntityMapper;
import blood.bank.infra.persistence.models.DonorChallengeEntity;
import blood.bank.infra.persistence.repositories.DonorChallengeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonorChallengeRepositoryJpa implements DonorChallengeRepositoryGateway {

    private final DonorChallengeRepository donorChallengeRepository;

    private final DonorChallengeEntityMapper donorChallengeEntityMapper;

    public DonorChallengeRepositoryJpa(DonorChallengeRepository donorChallengeRepository, DonorChallengeEntityMapper donorChallengeEntityMapper) {
        this.donorChallengeRepository = donorChallengeRepository;
        this.donorChallengeEntityMapper = donorChallengeEntityMapper;
    }

    @Override
    public List<DonorChallenge> getDonorChallengeByDonorFullNameAndEmail(String donorName, String email) {
        List<DonorChallengeEntity> donorChallengeEntities = this.donorChallengeRepository.findAllByDonor_People_FullNameAndDonor_People_Email(donorName, email);
        return donorChallengeEntities.stream().map(DonorChallengeEntityMapper::toDonorChallenge).collect(Collectors.toList());
    }
}
