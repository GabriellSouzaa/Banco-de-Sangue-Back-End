package blood.bank.application.usecases.user;

import blood.bank.application.gateways.UserRepositoryGateway;
import blood.bank.domain.entities.user.User;

public class GetUser {

    private final UserRepositoryGateway userRepositoryGateway;

    public GetUser(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    public User getUser(String username) {
        return userRepositoryGateway.getUser(username);
    }
}
