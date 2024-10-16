package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.RewardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<RewardEntity, Long > {
}
