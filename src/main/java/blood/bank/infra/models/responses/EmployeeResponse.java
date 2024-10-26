package blood.bank.infra.models.responses;

import blood.bank.domain.entities.employee.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeResponse {

    private PeopleResponse people;

    private AddressResponse address;

    private String cpf;

    private LocalDate hiringDate;

    private String position;

    private String department;

    private BigDecimal salary;

    private String professionalRegistrationNumber;

    private UUID photo;

    public EmployeeResponse(Employee  employee) {
        this.people = new PeopleResponse(employee.getPeople());
        this.address = new AddressResponse(employee.getAddress());
        this.cpf = employee.getCpf();
        this.hiringDate = employee.getHiringDate();
        this.position = employee.getPosition();
        this.department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.professionalRegistrationNumber = employee.getProfessionalRegistrationNumber();
        this.photo = employee.getPhoto();
    }

    public PeopleResponse getPeople() {
        return people;
    }

    public void setPeople(PeopleResponse people) {
        this.people = people;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getProfessionalRegistrationNumber() {
        return professionalRegistrationNumber;
    }

    public void setProfessionalRegistrationNumber(String professionalRegistrationNumber) {
        this.professionalRegistrationNumber = professionalRegistrationNumber;
    }

    public UUID getPhoto() {
        return photo;
    }

    public void setPhoto(UUID photo) {
        this.photo = photo;
    }
}
