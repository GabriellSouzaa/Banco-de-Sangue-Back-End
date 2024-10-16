package blood.bank.infra.models.requests;

import blood.bank.domain.enums.UserRole;

public class UserRequest {

    String login;

    String password;

    UserRole role;

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
