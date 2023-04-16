package ru.antonsibgatulin.serviceapiserver.controllers.api.profile;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.profile.request.UpdateAccountRequest;
import ru.antonsibgatulin.serviceapiserver.user.User;
import ru.antonsibgatulin.serviceapiserver.user.repository.AccountRepository;
import ru.antonsibgatulin.serviceapiserver.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;
    private final AccountRepository accountRepository;

    public ProfileController(UserRepository userRepository, TokenUserRepository tokenUserRepository, AccountRepository accountRepository) {

        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
        this.accountRepository = accountRepository;

    }

    @RequestMapping("/save")
    public User saveAccount(@Valid @RequestBody UpdateAccountRequest updateAccountRequest){

        return null;
    }

}
