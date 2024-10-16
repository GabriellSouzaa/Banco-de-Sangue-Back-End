package blood.bank.application.usecases.user;

import blood.bank.application.gateways.UserRepositoryGateway;
import blood.bank.infra.models.responses.UserResponse;

public class LoginUser {

    public final UserRepositoryGateway userRepositoryGateway;

    public LoginUser(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    public String login(UserResponse userResponse) {
     return this.userRepositoryGateway.loginUser(userResponse);
    }
}
