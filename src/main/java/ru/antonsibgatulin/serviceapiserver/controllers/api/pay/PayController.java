package ru.antonsibgatulin.serviceapiserver.controllers.api.pay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.service.pay.repository.PayRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class PayController {
    private final UserRepository userRepository;
    private final PayRepository payRepository;
    private final TokenUserRepository tokenUserRepository;


    public PayController(UserRepository userRepository, PayRepository payRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.payRepository = payRepository;
        this.tokenUserRepository = tokenUserRepository;
    }
}
