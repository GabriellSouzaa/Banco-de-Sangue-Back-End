package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.BloodBagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBagRepository extends JpaRepository<BloodBagEntity, Long> {

    BloodBagEntity findBloodBagEntityByBatchCode(String batchCode);
}
