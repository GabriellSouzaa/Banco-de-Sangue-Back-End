package blood.bank.application.gateways;

import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.models.requests.EmployeeRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeRepositoryGateway {
    List<Employee> getEmployees();

    void createEmployee(EmployeeRequest employeeRequest, MultipartFile photo);

    void updateEmployee(String cpf, EmployeeRequest employeeRequest);

    void deleteEmployee(String cpf);
}
