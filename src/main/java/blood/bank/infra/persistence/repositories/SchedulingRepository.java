package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {

    List<SchedulingEntity> findAllByDonorId(Long idDonor);

}
