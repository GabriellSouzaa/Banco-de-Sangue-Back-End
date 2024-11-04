package blood.bank.application.usecases.employee;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.infra.models.requests.EmployeeRequest;

public class UpdateEmployee {

    private final EmployeeRepositoryGateway employeeRepositoryGateway;

    public UpdateEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        this.employeeRepositoryGateway = employeeRepositoryGateway;
    }

    public void updateEmployee(String cpf, EmployeeRequest employeeRequest){
        this.employeeRepositoryGateway.updateEmployee(cpf, employeeRequest);
    }
}
