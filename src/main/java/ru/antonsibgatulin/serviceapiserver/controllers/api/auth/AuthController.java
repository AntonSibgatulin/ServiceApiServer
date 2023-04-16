package ru.antonsibgatulin.serviceapiserver.controllers.api.auth;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.exception.UserPasswordNotValid;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.request.AuthRequest;
import ru.antonsibgatulin.serviceapiserver.include.TokenGenerator;
import ru.antonsibgatulin.serviceapiserver.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.user.User;
import ru.antonsibgatulin.serviceapiserver.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.user.repository.UserRepository;


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
    public User getUser(@Valid @RequestBody AuthRequest authRequest/*, BindingResult bindingResult */){
        User user = userRepository.getUserByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());

        if (user == null){
            throw new UserPasswordNotValid();
        }

        tokenUserRepository.save(new TokenUser(null,user.getUserId(), TokenGenerator.generateTokenBy(user)));

        return user;
    }


}
