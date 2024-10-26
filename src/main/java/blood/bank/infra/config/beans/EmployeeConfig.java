package blood.bank.infra.config.beans;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.application.usecases.employee.ListEmployee;
import blood.bank.infra.gateways.EmployeeRepositoryJpa;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.persistence.repositories.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    EmployeeEntityMapper employeeEntityMapper() {
        return new EmployeeEntityMapper();
    }

    @Bean
    EmployeeRepositoryJpa employeeRepositoryJpa(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper) {
        return new EmployeeRepositoryJpa(employeeRepository, employeeEntityMapper);
    }

    @Bean
    ListEmployee listEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        return new ListEmployee(employeeRepositoryGateway);
    }
}
