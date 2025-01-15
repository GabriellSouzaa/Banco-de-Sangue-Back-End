package blood.bank.infra.mappers;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.people.People;
import blood.bank.domain.entities.user.User;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.models.PeopleEntity;
import blood.bank.infra.persistence.models.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user){
        EmployeeEntity employee  = EmployeeEntityMapper.toEntity(user.getEmployee());
        DonorEntity donor = DonorMapper.toEntity(user.getDonor());
        return new UserEntity(user.getLogin(), user.getPassword(), user.getRole(), employee, donor);
    }

    public User toUser(UserEntity userEntity){
        Employee employee = EmployeeEntityMapper.toEmployee(userEntity.getEmployee());
        Donor donor = DonorMapper.toDonor(userEntity.getDonor());
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getRole(), employee, donor);
    }
}
