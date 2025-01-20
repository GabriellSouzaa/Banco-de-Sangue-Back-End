package blood.bank.infra.controller;

import blood.bank.application.usecases.user.LoginUser;
import blood.bank.application.usecases.user.RegisterUser;
import blood.bank.domain.entities.user.User;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.models.requests.UserRequest;
import blood.bank.infra.models.responses.UserResponse;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/auth")
public class AuthenticationController {

    public final RegisterUser registerUser;

    public final LoginUser loginUser;

    private final EmployeeRepository employeeRepository;

    private final DonorRepository donorRepository;


    public AuthenticationController(RegisterUser registerUser, LoginUser loginUser, EmployeeRepository employeeRepository, DonorRepository donorRepository) {
        this.registerUser = registerUser;
        this.loginUser = loginUser;
        this.employeeRepository = employeeRepository;
        this.donorRepository = donorRepository;
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
}
