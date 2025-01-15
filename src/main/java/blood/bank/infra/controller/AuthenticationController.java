package blood.bank.infra.controller;

import blood.bank.application.usecases.user.LoginUser;
import blood.bank.application.usecases.user.RegisterUser;
import blood.bank.domain.entities.address.Address;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.people.People;
import blood.bank.domain.entities.user.User;
import blood.bank.infra.models.requests.UserRequest;
import blood.bank.infra.models.responses.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/auth")
public class AuthenticationController {

    public final RegisterUser registerUser;

    public final LoginUser loginUser;

    public AuthenticationController(RegisterUser registerUser, LoginUser loginUser) {
        this.registerUser = registerUser;
        this.loginUser = loginUser;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserResponse userResponse){
        return loginUser.login(userResponse);
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest) {

        People peopleEmployee = new People(userRequest.getEmployee().getPeople().getFullName(), userRequest.getEmployee().getPeople().getDateOfBirth(), userRequest.getEmployee().getPeople().getGender(), userRequest.getEmployee().getPeople().getEmail());
        Address address = new Address(userRequest.getEmployee().getAddress().getStreet(), userRequest.getEmployee().getAddress().getNumber(), userRequest.getEmployee().getAddress().getNeighborhood(), userRequest.getEmployee().getAddress().getCity(), userRequest.getEmployee().getAddress().getState(), userRequest.getEmployee().getAddress().getPostalCode());

        Employee employee = new Employee(peopleEmployee, address, userRequest.getEmployee().getCpf(), userRequest.getEmployee().getHiringDate(), userRequest.getEmployee().getPosition(), userRequest.getEmployee().getDepartment(), userRequest.getEmployee().getSalary(), userRequest.getEmployee().getProfessionalRegistrationNumber(), userRequest.getEmployee().getPhoto());

        People peopleDonor = new People(userRequest.getDonor().getPeople().getFullName(), userRequest.getDonor().getPeople().getDateOfBirth(), userRequest.getDonor().getPeople().getGender(), userRequest.getDonor().getPeople().getEmail());

        Donor donor = new Donor(peopleDonor, userRequest.getDonor().getBloodType(), userRequest.getDonor().getRegisterDate(), userRequest.getDonor().getLastDonationDate(), userRequest.getDonor().getNumberOfDonations(), userRequest.getDonor().getEligibility(), userRequest.getDonor().getMedicalNotes(), userRequest.getDonor().getbCoinsBalance(), userRequest.getDonor().getImage());

        User save = registerUser.register(new User(userRequest.getLogin(), userRequest.getPassword(), userRequest.getRole(), employee, donor));
        return new UserResponse(save.getLogin(), save.getPassword());
    }
}
