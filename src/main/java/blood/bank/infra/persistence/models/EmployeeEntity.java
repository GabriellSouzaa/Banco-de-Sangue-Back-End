package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "funcionario")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_id_seq")
    @SequenceGenerator(name = "funcionario_id_seq", sequenceName = "funcionario_id_seq", allocationSize = 1)
    @Column(name = "id_funcionario")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pessoa_id_pessoa")
    private PeopleEntity people;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_endereco")
    private AddressEntity address;

    private String cpf;

    @Column(name = "data_contratacao")
    private LocalDate hiringDate;

    @Column(name = "cargo")
    private String position;

    @Column(name = "departamento")
    private String department;

    @Column(name = "salario")
    private BigDecimal salary;

    @Column(name = "numero_registro_profissional")
    private String professionalRegistrationNumber;

    @Column(name = "foto")
    private String photo;

    public EmployeeEntity(PeopleEntity people, AddressEntity address, String cpf, LocalDate hiringDate, String position, String department, BigDecimal salary, String professionalRegistrationNumber, String photo) {
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

    public EmployeeEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
