package banco.sangue.infrastructure.persistence.repositories;


import banco.sangue.infrastructure.persistence.entities.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeData extends JpaRepository<ChallengeEntity, Long> {
}
