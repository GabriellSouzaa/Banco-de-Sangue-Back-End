package blood.bank.infra.controller;

import blood.bank.application.usecases.employee.CreateEmployee;
import blood.bank.application.usecases.employee.DeleteEmployee;
import blood.bank.application.usecases.employee.ListEmployee;
import blood.bank.application.usecases.employee.UpdateEmployee;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.models.requests.EmployeeRequest;
import blood.bank.infra.models.responses.EmployeeResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final ListEmployee listEmployee;

    private final CreateEmployee createEmployee;

    private final UpdateEmployee updateEmployee;

    private final DeleteEmployee deleteEmployee;

    public EmployeeController(ListEmployee listEmployee, CreateEmployee createEmployee, UpdateEmployee updateEmployee, DeleteEmployee deleteEmployee) {
        this.listEmployee = listEmployee;
        this.createEmployee = createEmployee;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    @GetMapping
    List<EmployeeResponse> employees() {
        List<Employee> employees = listEmployee.getEmployees();
        return employees.stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void createEmployee(
            @RequestPart("employee") EmployeeRequest employeeRequest,
            @RequestPart("photo") MultipartFile photo
    ) {
        this.createEmployee.createEmployee(employeeRequest, photo);
    }

    @PutMapping
    void updateEmployee(@RequestParam String cpf, @RequestBody EmployeeRequest employeeRequest) {
        this.updateEmployee.updateEmployee(cpf, employeeRequest);
    }

    @DeleteMapping
    void deleteEmployee(@RequestParam String cpf) {
        this.deleteEmployee.deleteEmployee(cpf);
    }
}
