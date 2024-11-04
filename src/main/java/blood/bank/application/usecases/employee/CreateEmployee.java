package blood.bank.application.usecases.employee;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.infra.models.requests.EmployeeRequest;

public class CreateEmployee {

    private final EmployeeRepositoryGateway employeeRepositoryGateway;

    public CreateEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        this.employeeRepositoryGateway = employeeRepositoryGateway;
    }

    public void createEmployee(EmployeeRequest employeeRequest){
        this.employeeRepositoryGateway.createEmployee(employeeRequest);
    }
}
