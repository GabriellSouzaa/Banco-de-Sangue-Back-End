package blood.bank.infra.config.beans;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.application.usecases.employee.CreateEmployee;
import blood.bank.application.usecases.employee.DeleteEmployee;
import blood.bank.application.usecases.employee.ListEmployee;
import blood.bank.application.usecases.employee.UpdateEmployee;
import blood.bank.infra.gateways.EmployeeRepositoryJpa;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.persistence.repositories.EmployeeRepository;
import blood.bank.infra.persistence.repositories.PeopleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    EmployeeEntityMapper employeeEntityMapper() {
        return new EmployeeEntityMapper();
    }

    @Bean
    EmployeeRepositoryJpa employeeRepositoryJpa(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper, PeopleRepository peopleRepository) {
        return new EmployeeRepositoryJpa(employeeRepository, employeeEntityMapper, peopleRepository);
    }

    @Bean
    ListEmployee listEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        return new ListEmployee(employeeRepositoryGateway);
    }

    @Bean
    CreateEmployee createEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        return new CreateEmployee(employeeRepositoryGateway);
    }

    @Bean
    UpdateEmployee updateEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        return new UpdateEmployee(employeeRepositoryGateway);
    }

    @Bean
    DeleteEmployee deleteEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        return new DeleteEmployee(employeeRepositoryGateway);
    }
}
