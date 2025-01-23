package blood.bank.infra.controller;

import blood.bank.application.usecases.user.GetUser;
import blood.bank.application.usecases.user.LoginUser;
import blood.bank.application.usecases.user.RegisterUser;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.user.User;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.models.requests.UserRequest;
import blood.bank.infra.models.responses.DonorResponse;
import blood.bank.infra.models.responses.EmployeeResponse;
import blood.bank.infra.models.responses.UserResponse;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/auth")
public class AuthenticationController {

    public final RegisterUser registerUser;

    public final LoginUser loginUser;

    private final EmployeeRepository employeeRepository;

    private final DonorRepository donorRepository;

    private final GetUser getUser;


    public AuthenticationController(RegisterUser registerUser, LoginUser loginUser, EmployeeRepository employeeRepository, DonorRepository donorRepository, GetUser getUser) {
        this.registerUser = registerUser;
        this.loginUser = loginUser;
        this.employeeRepository = employeeRepository;
        this.donorRepository = donorRepository;
        this.getUser = getUser;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserResponse userResponse) {
        return loginUser.login(userResponse);
    }

    @PostMapping("/register-employee")
    public UserResponse register(@RequestBody UserRequest userRequest) {

        EmployeeEntity employeeEntity = employeeRepository.findById(userRequest.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        User save = registerUser.register(new User(userRequest.getLogin(), userRequest.getPassword(), userRequest.getRole(), EmployeeEntityMapper.toEmployee(employeeEntity), null));

        return new UserResponse(save.getLogin(), save.getPassword());
    }

    @PostMapping("/register-donor")
    public UserResponse registerDonor(@RequestBody UserRequest userRequest) {


        DonorEntity donorEntity = donorRepository.findById(userRequest.getDonorId()).orElseThrow(
                () -> new RuntimeException("Donor not found")
        );

        User save = registerUser.register(new User(userRequest.getLogin(), userRequest.getPassword(), userRequest.getRole(), null, DonorMapper.toDonor(donorEntity)));

        return new UserResponse(save.getLogin(), save.getPassword());

    }

    @GetMapping("/get-authenticated-employee/{login}")
    public ResponseEntity<EmployeeResponse> getAuthenticatedEmployee(@PathVariable String login) {

        Employee employee = getUser.getUser(login).getEmployee();

        return ResponseEntity.ok(new EmployeeResponse(employee));
    }

    @GetMapping("/get-authenticated-donor/{login}")
    public ResponseEntity<DonorResponse> getAuthenticatedDonor(@PathVariable String login) {

        Donor donor = getUser.getUser(login).getDonor();

        return ResponseEntity.ok(new DonorResponse(donor));
    }
}
