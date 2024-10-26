package blood.bank.infra.mappers;

import blood.bank.domain.entities.address.Address;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.people.People;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.models.PeopleEntity;

public class EmployeeEntityMapper {

    public static EmployeeEntity toEntity(Employee employee) {
        PeopleEntity peopleEntity = PeopleEntityMapper.toEntity(employee.getPeople());
        AddressEntity addressEntity = AddressEntityMapper.toEntity(employee.getAddress());
        return new EmployeeEntity(peopleEntity, addressEntity, employee.getCpf(), employee.getHiringDate(), employee.getPosition(), employee.getDepartment(), employee.getSalary(), employee.getProfessionalRegistrationNumber(), employee.getPhoto());
    }

    public static Employee toEmployee(EmployeeEntity employeeEntity){
        People people = PeopleEntityMapper.toPeople(employeeEntity.getPeople());
        Address address = AddressEntityMapper.toAddress(employeeEntity.getAddress());
        return new Employee(people, address, employeeEntity.getCpf(), employeeEntity.getHiringDate(), employeeEntity.getPosition(), employeeEntity.getDepartment(), employeeEntity.getSalary(), employeeEntity.getProfessionalRegistrationNumber(), employeeEntity.getPhoto());
    }
}
