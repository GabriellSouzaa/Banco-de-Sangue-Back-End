package blood.bank.application.usecases.user;

import blood.bank.application.gateways.UserRepositoryGateway;
import blood.bank.domain.entities.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegisterUser {

    public final UserRepositoryGateway repository;

    public RegisterUser( UserRepositoryGateway repository) {
        this.repository = repository;
    }

    public User register(User user) {
        boolean userCheck = this.repository.checkLogin(user.getLogin());
        if(userCheck) {
            throw new IllegalArgumentException("Usuário já existe");
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return repository.register(user);
            }
        }

}
