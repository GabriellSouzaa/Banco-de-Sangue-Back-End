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

    public UserEntity toEntity(User user) {
        EmployeeEntity employee = user.getEmployee() != null ? EmployeeEntityMapper.toEntity(user.getEmployee()) : null;
        DonorEntity donor = user.getDonor() != null ? DonorMapper.toEntity(user.getDonor()) : null;
        return new UserEntity(user.getLogin(), user.getPassword(), user.getRole(), employee, donor);
    }

    public User toUser(UserEntity userEntity){
        Employee employee = userEntity.getEmployee() != null ? EmployeeEntityMapper.toEmployee(userEntity.getEmployee()) : null;
        Donor donor = userEntity.getDonor() != null ? DonorMapper.toDonor(userEntity.getDonor()) : null;
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getRole(), employee, donor);
    }
}
