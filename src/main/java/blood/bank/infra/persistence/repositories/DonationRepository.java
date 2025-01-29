package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    Optional<DonationEntity> findByDateDonation(LocalDate date);

    List<DonationEntity> findAllByDonorId(Long idDonor);
}
