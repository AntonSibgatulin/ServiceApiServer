package ru.antonsibgatulin.serviceapiserver.controllers.api.auth;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.exception.UserPasswordNotValid;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.request.AuthRequest;
import ru.antonsibgatulin.serviceapiserver.include.TokenGenerator;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;

    public AuthController(UserRepository userRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
    }


    @PostMapping(name = "/")
    public User getUser(@Valid @RequestBody AuthRequest authRequest){
        User user = userRepository.getUserByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());

        if (user == null){
            throw new UserPasswordNotValid();
        }
        TokenUser tokenUser = new TokenUser(null,user.getUserId(), TokenGenerator.generateTokenBy(user));
        user.setToken(tokenUser.getToken());
        tokenUserRepository.save(tokenUser);

        return user;
    }


}
