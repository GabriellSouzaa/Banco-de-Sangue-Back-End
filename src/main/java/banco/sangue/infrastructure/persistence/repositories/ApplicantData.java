package banco.sangue.infrastructure.persistence.repositories;

import banco.sangue.infrastructure.persistence.entities.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantData  extends JpaRepository<ApplicantEntity, Long> {
}
