package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.BloodCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCenterRepository extends JpaRepository<BloodCenterEntity, Long> {
}
