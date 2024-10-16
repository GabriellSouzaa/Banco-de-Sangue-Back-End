package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {
}
