package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.HospitalClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalClinicRepository extends JpaRepository<HospitalClinicEntity, Long> {
}
