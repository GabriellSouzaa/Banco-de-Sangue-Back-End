package blood.bank.infra.mappers;

import blood.bank.domain.entities.user.User;
import blood.bank.infra.persistence.models.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(user.getLogin(), user.getPassword(), user.getRole());
    }

    public User toUser(UserEntity userEntity){
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getRole());
    }
}
