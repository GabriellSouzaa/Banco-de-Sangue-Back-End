package blood.bank.application.gateways;

import blood.bank.domain.entities.employee.Employee;

import java.util.List;

public interface EmployeeRepositoryGateway {
    List<Employee> getEmployees();
}
