package ru.antonsibgatulin.serviceapiserver.controllers.api.reg;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.reg.request.RegRequest;
import ru.antonsibgatulin.serviceapiserver.include.TokenGenerator;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;
import ru.antonsibgatulin.serviceapiserver.service.money.Money;
import ru.antonsibgatulin.serviceapiserver.service.places.repository.CityRepository;
import ru.antonsibgatulin.serviceapiserver.service.places.repository.RegionRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.Account;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class RegController {




    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;

    public RegController(UserRepository userRepository, TokenUserRepository tokenUserRepository, RegionRepository regionRepository, CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
        this.regionRepository = regionRepository;
        this.cityRepository = cityRepository;
    }

    /*
        @PostMapping("/")
        public User registerUser(@Valid @RequestBody RegRequest regRequest){
            Long time = System.currentTimeMillis();
            User user = new User(regRequest.getLogin(),regRequest.getPassword(),regRequest.getEmail(),regRequest.getNumber(),regRequest.getName(),regRequest.getSurname(),regRequest.getTypeUser(),0L,time,time);
            user.setAccount(new Account(null,null,null,0,0,0L,0L,0));
            user.setMoney(new Money(null,0.0));
            userRepository.save(user);
            return user;
        }
    */
    @PostMapping("/reg")
    public TypeResult registerUser(@Valid @RequestBody RegRequest regRequest) throws Exception {

        if (regRequest.getException()!=null){
            return regRequest.getException();

        }else {
            Long time = System.currentTimeMillis();
            User user = new User(regRequest.getLogin(), regRequest.getPassword(), regRequest.getEmail(), regRequest.getNumber(), regRequest.getName(), regRequest.getSurname(), regRequest.getTypeUser(), 0L, time, time);
            user.setActionPage(0);
            user.setAccount(new Account(null, null, null, 0, 0, null, null, 0));
            user.setMoney(new Money(null, 0.0));

            if(userRepository.getUserByLogin(user.getLogin())==null){
                if(userRepository.getUserByNumber(user.getNumber()) == null){
                    if(userRepository.getUserByEmail(user.getEmail())==null){
                        user = userRepository.save(user);
                        userRepository.flush();
                    }else{
                        return new TypeResult("error",802,"reg");
                    }
                }else{
                    return new TypeResult("error",801,"reg");
                }
            }else{
                return new TypeResult("error",800,"reg");
            }


            /*
            if(userRepository.getUserByLogin(user.getLogin())==null && userRepository.getUserByNumber(user.getNumber()) == null && userRepository.getUserByEmail(user.getEmail())==null) {

            }else{

                return new TypeResult("error",800,"reg");
            }
             */


            TokenUser tokenUser = new TokenUser(null,user.getUserId(), TokenGenerator.generateTokenBy(user));
            user.setToken(tokenUser.getToken());
            tokenUserRepository.save(tokenUser);

            TypeResult typeResult = new TypeResult("ok",200,"reg");
            typeResult.setUser(user);
            return typeResult;
        }
    }


}
