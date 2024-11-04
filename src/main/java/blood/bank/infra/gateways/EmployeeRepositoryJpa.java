package blood.bank.infra.gateways;

import blood.bank.application.gateways.EmployeeRepositoryGateway;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.infra.mappers.EmployeeEntityMapper;
import blood.bank.infra.models.requests.EmployeeRequest;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.models.PeopleEntity;
import blood.bank.infra.persistence.repositories.EmployeeRepository;
import blood.bank.infra.persistence.repositories.PeopleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepositoryJpa implements EmployeeRepositoryGateway {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEntityMapper employeeEntityMapper;

    private final PeopleRepository peopleRepository;

    public EmployeeRepositoryJpa(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper, PeopleRepository peopleRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityMapper = employeeEntityMapper;
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(EmployeeEntityMapper::toEmployee).collect(Collectors.toList());
    }

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        PeopleEntity peopleEntity = new PeopleEntity();
        AddressEntity addressEntity = new AddressEntity();
        EmployeeEntity employeeEntity = new EmployeeEntity();

        peopleEntity.setFullName(employeeRequest.getPeople().getFullName());
        peopleEntity.setDateOfBirth(employeeRequest.getPeople().getDateOfBirth());
        peopleEntity.setGender(employeeRequest.getPeople().getGender());
        peopleEntity.setEmail(employeeRequest.getPeople().getEmail());

        peopleRepository.save(peopleEntity);

        addressEntity.setStreet(employeeRequest.getAddress().getStreet());
        addressEntity.setNumber(employeeRequest.getAddress().getNumber());
        addressEntity.setNeighborhood(employeeRequest.getAddress().getNeighborhood());
        addressEntity.setCity(employeeRequest.getAddress().getCity());
        addressEntity.setState(employeeRequest.getAddress().getState());
        addressEntity.setPostalCode(employeeRequest.getAddress().getPostalCode());

        employeeEntity.setPeople(peopleEntity);
        employeeEntity.setAddress(addressEntity);
        employeeEntity.setCpf(employeeRequest.getCpf());
        employeeEntity.setHiringDate(employeeRequest.getHiringDate());
        employeeEntity.setPosition(employeeRequest.getPosition());
        employeeEntity.setDepartment(employeeRequest.getDepartment());
        employeeEntity.setSalary(employeeRequest.getSalary());
        employeeEntity.setProfessionalRegistrationNumber(employeeRequest.getProfessionalRegistrationNumber());

        employeeRepository.save(employeeEntity);
    }


    @Override
    public void updateEmployee(String cpf, EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeEntityByCpf(cpf);

        PeopleEntity peopleEntity = employeeEntity.getPeople();
        AddressEntity addressEntity = employeeEntity.getAddress();

        peopleEntity.setFullName(employeeRequest.getPeople().getFullName());
        peopleEntity.setDateOfBirth(employeeRequest.getPeople().getDateOfBirth());
        peopleEntity.setGender(employeeRequest.getPeople().getGender());
        peopleEntity.setEmail(employeeRequest.getPeople().getEmail());
        addressEntity.setStreet(employeeRequest.getAddress().getStreet());
        addressEntity.setNumber(employeeRequest.getAddress().getNumber());
        addressEntity.setNeighborhood(employeeRequest.getAddress().getNeighborhood());
        addressEntity.setCity(employeeRequest.getAddress().getCity());
        addressEntity.setState(employeeRequest.getAddress().getState());
        addressEntity.setPostalCode(employeeRequest.getAddress().getPostalCode());
        employeeEntity.setPeople(peopleEntity);
        employeeEntity.setAddress(addressEntity);
        employeeEntity.setCpf(employeeRequest.getCpf());
        employeeEntity.setHiringDate(employeeRequest.getHiringDate());
        employeeEntity.setPosition(employeeRequest.getPosition());
        employeeEntity.setDepartment(employeeRequest.getDepartment());
        employeeEntity.setSalary(employeeRequest.getSalary());
        employeeEntity.setProfessionalRegistrationNumber(employeeRequest.getProfessionalRegistrationNumber());
        employeeEntity.setPeople(employeeEntity.getPeople());
        employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(String cpf) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeEntityByCpf(cpf);
        employeeRepository.delete(employeeEntity);
    }
}
