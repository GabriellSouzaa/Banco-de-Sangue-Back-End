package blood.bank.infra.mappers;

import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.persistence.models.ChallengeEntity;
import blood.bank.infra.persistence.models.DonorChallengeEntity;
import blood.bank.infra.persistence.models.DonorEntity;

public class DonorChallengeEntityMapper {

    public static DonorChallengeEntity toEntity(DonorChallenge donorChallenge) {
        DonorEntity donorEntity = new DonorEntity();
        ChallengeEntity challengeEntity = new ChallengeEntity();
        return new DonorChallengeEntity(donorEntity, challengeEntity);
    }

    public static DonorChallenge toDonorChallenge(DonorChallengeEntity donorChallengeEntity){
        Donor donor = DonorMapper.toDonor(donorChallengeEntity.getDonor());
        Challenge challenge = ChallengeEntityMapper.toChallenge(donorChallengeEntity.getChallenge());
        return new DonorChallenge(donor, challenge);
    }
}
