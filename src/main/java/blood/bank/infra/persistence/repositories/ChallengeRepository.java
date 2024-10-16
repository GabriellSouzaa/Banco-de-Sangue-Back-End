package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long> {
}
