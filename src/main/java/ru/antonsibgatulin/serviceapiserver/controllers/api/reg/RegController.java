package ru.antonsibgatulin.serviceapiserver.controllers.api.reg;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.reg.request.RegRequest;
import ru.antonsibgatulin.serviceapiserver.money.Money;
import ru.antonsibgatulin.serviceapiserver.user.Account;
import ru.antonsibgatulin.serviceapiserver.user.User;
import ru.antonsibgatulin.serviceapiserver.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/reg")
public class RegController {



    @Autowired
    private UserRepository userRepository;
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
    @PostMapping("/")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegRequest regRequest) throws Exception {

        if (regRequest.getException()!=null){
            throw regRequest.getException();

        }else {
            Long time = System.currentTimeMillis();
            User user = new User(regRequest.getLogin(), regRequest.getPassword(), regRequest.getEmail(), regRequest.getNumber(), regRequest.getName(), regRequest.getSurname(), regRequest.getTypeUser(), 0L, time, time);
            user.setAccount(new Account(null, null, null, 0, 0, 0L, 0L, 0));
            user.setMoney(new Money(null, 0.0));

            if(userRepository.getUserByLogin(user.getLogin())==null && userRepository.getUserByNumber(user.getNumber()) == null && userRepository.getUserByMail(user.getEmail())==null) {
                userRepository.save(user);
            }


            return ResponseEntity.status(200).body(user);
        }
    }


}
