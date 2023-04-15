package ru.antonsibgatulin.serviceapiserver.controllers.api.reg;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.user.User;
import ru.antonsibgatulin.serviceapiserver.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/reg")
public class RegController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public User registerUser(@Valid @RequestBody User user){

        return null;
    }



}
