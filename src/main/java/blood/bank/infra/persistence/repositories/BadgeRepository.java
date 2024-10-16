package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.BadgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<BadgeEntity, Long> {
}


