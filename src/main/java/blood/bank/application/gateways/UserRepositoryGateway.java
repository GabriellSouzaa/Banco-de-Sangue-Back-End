package blood.bank.application.gateways;

import blood.bank.domain.entities.user.User;
import blood.bank.infra.models.requests.UserRequest;
import blood.bank.infra.models.responses.UserResponse;

public interface UserRepositoryGateway {

    User register(User user);

    boolean checkLogin(String login);

    String loginUser(UserResponse userResponse);

}
