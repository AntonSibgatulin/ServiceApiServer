package ru.antonsibgatulin.serviceapiserver.controllers.api.auth;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.exception.UserPasswordNotValid;
import ru.antonsibgatulin.serviceapiserver.controllers.api.auth.request.AuthRequest;
import ru.antonsibgatulin.serviceapiserver.user.User;
import ru.antonsibgatulin.serviceapiserver.user.repository.UserRepository;


@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

   /* public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/


    @PostMapping(name = "/")
    public User getUser(@Valid @RequestBody AuthRequest authRequest/*, BindingResult bindingResult */){
        User user = userRepository.getUserByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());

        if (user == null){
            throw new UserPasswordNotValid();
        }

        return user;
    }


}
