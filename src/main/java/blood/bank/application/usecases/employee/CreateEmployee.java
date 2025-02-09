package blood.bank.application.usecases.employee;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.infra.models.requests.EmployeeRequest;
import org.springframework.web.multipart.MultipartFile;

public class CreateEmployee {

    private final EmployeeRepositoryGateway employeeRepositoryGateway;

    public CreateEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        this.employeeRepositoryGateway = employeeRepositoryGateway;
    }

    public void createEmployee(EmployeeRequest employeeRequest, MultipartFile photo){
        this.employeeRepositoryGateway.createEmployee(employeeRequest, photo);
    }
}
