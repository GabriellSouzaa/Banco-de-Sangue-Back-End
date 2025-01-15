package blood.bank.domain.enums;

public enum UserRole {

    ADMIN("admin"),
    USER("user"),
    GESTOR("gestor"),
    ENFERMEIRA("enfermeira"),
    ATENDENTE("atendente"),
    RH("rh");


    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
