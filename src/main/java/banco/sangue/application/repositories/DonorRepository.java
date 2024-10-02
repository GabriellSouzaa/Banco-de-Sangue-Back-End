package banco.sangue.application.repositories;

import banco.sangue.infrastructure.persistence.entities.DonorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository {

    List<DonorEntity> findAll();
}
