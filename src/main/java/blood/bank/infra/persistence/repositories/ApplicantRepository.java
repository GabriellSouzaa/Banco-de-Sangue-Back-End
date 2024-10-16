package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long> {
}
