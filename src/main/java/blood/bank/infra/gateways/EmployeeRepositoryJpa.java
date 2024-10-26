package blood.bank.infra.gateways;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepositoryJpa implements EmployeeRepositoryGateway {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEntityMapper employeeEntityMapper;

    public EmployeeRepositoryJpa(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(EmployeeEntityMapper::toEmployee).collect(Collectors.toList());
    }
}
