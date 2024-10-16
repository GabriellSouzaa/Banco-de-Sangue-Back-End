package blood.bank.config;

import blood.bank.application.gateways.UserRepositoryGateway;
import blood.bank.application.usecases.user.LoginUser;
import blood.bank.application.usecases.user.RegisterUser;
import blood.bank.infra.gateways.UserRepositoryJpa;
import blood.bank.infra.mappers.UserEntityMapper;
import blood.bank.infra.persistence.repositories.UserRepository;
import blood.bank.infra.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class UserConfig {

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserRepositoryJpa userRepositoryJpa(UserRepository userRepository, UserEntityMapper userEntityMapper, TokenService tokenService, AuthenticationManager authenticationManager) {
        return new UserRepositoryJpa(userRepository, userEntityMapper,  authenticationManager, tokenService);
    };

    @Bean
    RegisterUser registerUser(UserRepositoryGateway userRepositoryGateway) {
        return new RegisterUser( userRepositoryGateway);
    };

    @Bean
    LoginUser loginUser(UserRepositoryGateway userRepositoryGateway) {
        return new LoginUser( userRepositoryGateway);
    }
}
