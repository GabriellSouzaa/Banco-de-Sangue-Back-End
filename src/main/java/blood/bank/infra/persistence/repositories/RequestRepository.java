package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long > {
    RequestEntity findRequestEntityByPatientCpfAndRequestDate(String patientCpf, LocalDateTime requestDate);
}
