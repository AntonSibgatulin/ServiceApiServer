package ru.antonsibgatulin.serviceapiserver.controllers.api.profile;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.profile.request.UpdateAccountRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.service.places.repository.CityRepository;
import ru.antonsibgatulin.serviceapiserver.service.places.repository.RegionRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.Account;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.AccountRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;
    private final AccountRepository accountRepository;
    private final CityRepository cityRepository;
    private final RegionRepository regionRepository;


    public ProfileController(UserRepository userRepository, TokenUserRepository tokenUserRepository, AccountRepository accountRepository, CityRepository cityRepository, RegionRepository regionRepository) {

        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
        this.accountRepository = accountRepository;
        this.cityRepository = cityRepository;

        this.regionRepository = regionRepository;
    }

    @RequestMapping("/save")
    public User saveAccount(@Valid @RequestBody UpdateAccountRequest updateAccountRequest) throws Exception {

        if (updateAccountRequest.getException()!=null){
            throw updateAccountRequest.getException();
        }

        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(updateAccountRequest.getToken());
        User user = userRepository.getUserByUserId(tokenUser.getUserId());
        if (user == null){
            throw new UnauthorizedResponse();
        }

        Account account = user.getAccount();
        if (updateAccountRequest.getName()!=null && updateAccountRequest.getSurname()!=null){
            user.setName(updateAccountRequest.getName());
            user.setSurname(updateAccountRequest.getSurname());
            userRepository.save(user);
        }
        account.setMinDescription(updateAccountRequest.getMinDescription());
        account.setDescription(updateAccountRequest.getDescription());
        account.setStart(updateAccountRequest.getStart());
        account.setEnd(updateAccountRequest.getEnd());
        account.setDay(updateAccountRequest.getDay());
        account.setCity(cityRepository.getCityById(updateAccountRequest.getCity()));
        account.setRegion(regionRepository.getRegionById(updateAccountRequest.getRegion()));


        accountRepository.save(account);


        return user;
    }

}
