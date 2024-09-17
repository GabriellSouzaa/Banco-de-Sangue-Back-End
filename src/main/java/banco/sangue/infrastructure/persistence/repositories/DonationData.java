package banco.sangue.infrastructure.persistence.repositories;

import banco.sangue.infrastructure.persistence.entities.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationData extends JpaRepository<DonationEntity, Long> {
}
