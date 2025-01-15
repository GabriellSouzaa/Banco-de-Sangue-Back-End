package blood.bank.domain.entities.user;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.enums.UserRole;

public class User {

    private String login;

    private String password;

    private UserRole role;

    private Employee employee;

    private Donor donor;

    public User(String login, String password, UserRole role, Employee employee, Donor donor) {
        this.login = login;
        this.role = role;
        this.password = password;
        this.employee = employee;
        this.donor = donor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
