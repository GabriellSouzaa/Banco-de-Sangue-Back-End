package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface RequestHospitalClinicRepository extends JpaRepository<RequestHospitalClinicEntity, Long > {

    Optional<RequestHospitalClinicEntity> findByRequestDate(LocalDateTime dateOfRequest);
}
