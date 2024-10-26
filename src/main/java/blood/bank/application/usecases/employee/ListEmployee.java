package blood.bank.application.usecases.employee;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.domain.entities.employee.Employee;

import java.util.List;

public class ListEmployee {

    private final EmployeeRepositoryGateway employeeRepositoryGateway;

    public ListEmployee(final EmployeeRepositoryGateway employeeRepositoryGateway) {
        this.employeeRepositoryGateway = employeeRepositoryGateway;
    }

    public List<Employee> getEmployees() {
        return employeeRepositoryGateway.getEmployees();
    }
}
