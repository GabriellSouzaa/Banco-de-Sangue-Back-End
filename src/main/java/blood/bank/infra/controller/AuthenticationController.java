package blood.bank.infra.controller;

import blood.bank.application.usecases.user.LoginUser;
import blood.bank.application.usecases.user.RegisterUser;
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
        User save = registerUser.register(new User(userRequest.getLogin(), userRequest.getPassword(), userRequest.getRole()));
        return new UserResponse(save.getLogin(), save.getPassword());
    }
}
