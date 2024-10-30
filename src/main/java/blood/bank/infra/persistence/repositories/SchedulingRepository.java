package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {
}
