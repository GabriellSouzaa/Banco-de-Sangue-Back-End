package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long > {
}
