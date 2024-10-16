package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestHospitalClinicRepository extends JpaRepository<RequestHospitalClinicEntity, Long > {
}
