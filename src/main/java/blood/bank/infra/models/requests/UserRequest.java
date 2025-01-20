package blood.bank.infra.models.requests;

import blood.bank.domain.enums.UserRole;

public class UserRequest {

    String login;

    String password;

    UserRole role;

    Long employeeId;

    Long donorId;

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDonorId() {
        return donorId;
    }
}
