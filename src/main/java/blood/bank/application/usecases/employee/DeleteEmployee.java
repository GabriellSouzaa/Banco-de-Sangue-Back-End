package blood.bank.application.usecases.employee;

import blood.bank.application.gateways.EmployeeRepositoryGateway;

public class DeleteEmployee {

    private final EmployeeRepositoryGateway employeeRepositoryGateway;

    public DeleteEmployee(EmployeeRepositoryGateway employeeRepositoryGateway) {
        this.employeeRepositoryGateway = employeeRepositoryGateway;
    }

    public void deleteEmployee(String cpf){
        this.employeeRepositoryGateway.deleteEmployee(cpf);
    }
}
