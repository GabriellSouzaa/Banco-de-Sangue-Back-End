package blood.bank.domain.entities.employee;

import blood.bank.domain.entities.address.Address;
import blood.bank.domain.entities.people.People;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Employee {

    private People people;

    private Address address;

    private String cpf;

    private LocalDate hiringDate;

    private String position;

    private String department;

    private BigDecimal salary;

    private String professionalRegistrationNumber;

    private String photo;

    public Employee(People people, Address address, String cpf, LocalDate hiringDate, String position, String department, BigDecimal salary, String professionalRegistrationNumber, String photo) {
        this.people = people;
        this.address = address;
        this.cpf = cpf;
        this.hiringDate = hiringDate;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.professionalRegistrationNumber = professionalRegistrationNumber;
        this.photo = photo;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
