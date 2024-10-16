package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long > {
}
