package blood.bank.application.gateways;

import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.models.requests.EmployeeRequest;

import java.util.List;

public interface EmployeeRepositoryGateway {
    List<Employee> getEmployees();

    void createEmployee(EmployeeRequest employeeRequest);

    void updateEmployee(String cpf, EmployeeRequest employeeRequest);

    void deleteEmployee(String cpf);
}
