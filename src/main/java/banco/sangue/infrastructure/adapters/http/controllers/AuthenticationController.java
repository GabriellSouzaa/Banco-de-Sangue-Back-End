package banco.sangue.infrastructure.adapters.http.controllers;

import banco.sangue.infrastructure.adapters.http.models.request.RegisterRequest;
import banco.sangue.infrastructure.adapters.http.models.response.AuthenticationResponse;
import banco.sangue.infrastructure.adapters.http.models.response.LoginResponse;
import banco.sangue.infrastructure.persistence.entities.UserEntity;
import banco.sangue.infrastructure.persistence.repositories.UserData;
import banco.sangue.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserData repository;

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(UserData repository, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationResponse data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
