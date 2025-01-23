package blood.bank.infra.gateways;

import blood.bank.application.gateways.UserRepositoryGateway;
import blood.bank.domain.entities.user.User;
import blood.bank.infra.mappers.UserEntityMapper;
import blood.bank.infra.models.responses.UserResponse;
import blood.bank.infra.persistence.models.UserEntity;
import blood.bank.infra.persistence.repositories.UserRepository;
import blood.bank.infra.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class UserRepositoryJpa  implements UserRepositoryGateway {

    public final UserRepository userRepository;

    public final UserEntityMapper userEntityMapper;

    public final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public UserRepositoryJpa(UserRepository userRepository, UserEntityMapper userEntityMapper, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public User register(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        this.userRepository.save(userEntity);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public boolean checkLogin(String login) {
        boolean user = false;
        Optional<UserEntity> userEntity = userRepository.findByLogin(login);
        if(userEntity.isPresent()) {
            user = true;
        }
        return user;
    }

    @Override
    public String loginUser(UserResponse userResponse) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userResponse.login(), userResponse.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((UserEntity) auth.getPrincipal());
    }

    @Override
    public User getUser(String login) {
        Optional<UserEntity> userEntity = userRepository.findByLogin(login);
        if(userEntity.isPresent()) {
            return userEntityMapper.toUser(userEntity.get());
        }else{
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }
}
