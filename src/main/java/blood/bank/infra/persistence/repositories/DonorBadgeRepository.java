package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.DonorBadgeEntity;
import blood.bank.infra.persistence.models.DonorBadgeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorBadgeRepository extends JpaRepository<DonorBadgeEntity, DonorBadgeId> {
    List<DonorBadgeEntity> findDonorBadgeEntitiesByDonor_Id(Long donorId);
}
