package banco.sangue.infrastructure.persistence.repositories;

import banco.sangue.infrastructure.persistence.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestData extends JpaRepository<RequestEntity, Long > {
}
