package ru.antonsibgatulin.serviceapiserver.controllers.api.pay;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.serviceapiserver.controllers.api.pay.request.PayRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.include.request.DeleteRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;
import ru.antonsibgatulin.serviceapiserver.service.pay.Pay;
import ru.antonsibgatulin.serviceapiserver.service.pay.repository.PayMapper;
import ru.antonsibgatulin.serviceapiserver.service.pay.repository.PayRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/pay")
public class PayController {
    private final UserRepository userRepository;
    private final PayRepository payRepository;
    private final TokenUserRepository tokenUserRepository;
    private final PayMapper payMapper;



    public PayController(UserRepository userRepository, PayRepository payRepository, TokenUserRepository tokenUserRepository, PayMapper payMapper) {
        this.userRepository = userRepository;
        this.payRepository = payRepository;
        this.tokenUserRepository = tokenUserRepository;
        this.payMapper = payMapper;
    }


    @PostMapping("/save")
    public TypeResult savePay(@Valid @RequestBody PayRequest payRequest) throws Exception {

        if(payRequest.checkToken()!=null){
            return payRequest.checkToken();
        }

        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(payRequest.getToken());
        if(tokenUser==null){
            return new UnauthorizedResponse().getError();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());

        Pay del = user.deletePayAnotherByType(payRequest.getType());
        if(del!=null){
            payRepository.delete(del);

        }
        Pay pay_save = payMapper.fromPayRequesttoPay(payRequest);

        user.pays.add(pay_save);
        userRepository.save(user);
        TypeResult typeResult = new TypeResult("ok",200,"pay_save");
        typeResult.setUser(user);
        return typeResult;
    }


    @PostMapping("/delete/{type}")
    public TypeResult delete(@PathVariable("type")Integer type, @Valid @RequestBody DeleteRequest deleteRequest) throws Exception {

        if(deleteRequest.checkToken()!=null){
            return deleteRequest.checkToken();
        }
        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(deleteRequest.getToken());
        if(tokenUser==null){
            return new UnauthorizedResponse().getError();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());

        Pay del = user.deletePayAnotherByType(type);
        if(del!=null){
            payRepository.delete(del);

        }

        userRepository.save(user);

        TypeResult typeResult = new TypeResult("ok",200,"delete_pay");
        typeResult.setUser(user);
        return typeResult;

    }
}
