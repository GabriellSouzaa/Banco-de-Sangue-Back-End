package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.DonorChallengeEntity;
import blood.bank.infra.persistence.models.DonorChallengeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorChallengeRepository extends JpaRepository<DonorChallengeEntity, DonorChallengeId> {
    List<DonorChallengeEntity> findAllByDonor_People_FullNameAndDonor_People_Email(String fullName, String email);
}
