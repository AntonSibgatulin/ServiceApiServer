package ru.antonsibgatulin.serviceapiserver.controllers.api.get;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.get.request.UserByTokenRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.NotFoundRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;

    public GetController(UserRepository userRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
    }

    @PostMapping("/userByToken")
    public TypeResult getAccount(@Valid @RequestBody UserByTokenRequest userByTokenRequest) throws Exception {

        if (userByTokenRequest.getException()!=null){
            throw userByTokenRequest.getException();

        }

        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(userByTokenRequest.getToken());
        if (tokenUser == null){
            throw new UnauthorizedResponse();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());
        TypeResult typeResult = new TypeResult("ok",200,"user_by_token");
        typeResult.setUser(user);
        return  typeResult;


    }


    @PostMapping("/getUserById")
    public TypeResult getAccountById(@Valid @RequestBody UserByTokenRequest userByTokenRequest){
        //access get another user without token

        if(userByTokenRequest.getId_user()==null){
            throw new BadRequest();
        }
        User user = userRepository.getUserByUserId(userByTokenRequest.getId_user());

        if(user==null){
            throw new NotFoundRequest();
        }
        user.predict();
        TypeResult typeResult = new TypeResult("ok",200,"get_user_by_id");
        typeResult.setUser(user);
        return typeResult;
    }

}
