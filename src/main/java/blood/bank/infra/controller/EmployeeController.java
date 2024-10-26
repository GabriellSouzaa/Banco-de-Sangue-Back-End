package blood.bank.infra.controller;

import blood.bank.application.usecases.employee.ListEmployee;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.models.responses.EmployeeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final ListEmployee listEmployee;

    public EmployeeController(ListEmployee listEmployee) {
        this.listEmployee = listEmployee;
    }

    @GetMapping
    List<EmployeeResponse> employees() {
        List<Employee> employees = listEmployee.getEmployees();
        return employees.stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }
}
