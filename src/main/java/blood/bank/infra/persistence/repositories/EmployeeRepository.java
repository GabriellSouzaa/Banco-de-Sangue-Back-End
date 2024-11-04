package blood.bank.infra.persistence.repositories;


import blood.bank.infra.persistence.models.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findEmployeeEntityByCpf(String cpf);
}
