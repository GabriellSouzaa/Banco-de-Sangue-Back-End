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

    private UUID photo;
}
