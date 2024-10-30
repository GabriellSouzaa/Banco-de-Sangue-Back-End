package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.DonorRewardEntity;
import blood.bank.infra.persistence.models.DonorRewardId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRewardRepository extends JpaRepository<DonorRewardEntity, DonorRewardId> {
    List<DonorRewardEntity> findAllByDonor_Id(Long donorId);
}
