package banco.sangue.infrastructure.persistence.repositories;

import banco.sangue.infrastructure.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeData extends JpaRepository<EmployeeEntity, Long> {
}
