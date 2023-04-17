package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket;

import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request.StockMarketDeleteRequest;
import ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request.StockMarketRequestModel;
import ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request.StockMarketRequestModelMapper;
import ru.antonsibgatulin.serviceapiserver.include.StaticContent;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.ForbiddenException;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.RestrictionOnCreateObjects;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.StockMarket;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.repostitory.StockMarketRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class StockMarketController {
    private final UserRepository userRepository;
    private final StockMarketRequestModelMapper stockMarketRequestModelMapper;
    private final StockMarketRepository stockMarketRepository;
    private final TokenUserRepository tokenUserRepository;

    public StockMarketController(UserRepository userRepository, StockMarketRequestModelMapper stockMarketRequestModelMappert, StockMarketRepository stockMarketRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.stockMarketRequestModelMapper = stockMarketRequestModelMappert;
        this.stockMarketRepository = stockMarketRepository;
        this.tokenUserRepository = tokenUserRepository;
    }

    @PostMapping("/create")
    public StockMarket create(@Valid @RequestBody StockMarketRequestModel stockMarketRequestModel) throws Exception {
        if(stockMarketRequestModel.checkToken()!=null){
            throw stockMarketRequestModel.checkToken();
        }

        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(stockMarketRequestModel.getToken());
        if(tokenUser == null){
            throw new UnauthorizedResponse();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());

        if(stockMarketRepository.findAllWhereTimeCreateMoreThemNumber(StaticContent.timeToDay(),user.getUserId()).size()>5){
            throw new RestrictionOnCreateObjects();

        }

        StockMarket stockMarket = stockMarketRequestModelMapper.FromRequestToStockMarket(stockMarketRequestModel);
        stockMarket.setUserId(user.getUserId());
        stockMarket.init();
        user.stockMarkets.add(stockMarket);
        user = userRepository.save(user);
        userRepository.flush();
        //stockMarket = stockMarketRepository.save(stockMarket);
       // stockMarketRepository.flush();
        return user.stockMarkets.get(user.stockMarkets.size()-1);
    }


    @PostMapping("/delete/{id}")
    public JSONObject delete(@PathVariable("id") Long id, @Valid @RequestBody StockMarketDeleteRequest stockMarketDeleteRequest) throws Exception {
        JSONObject jsonObject = new JSONObject();

        if(stockMarketDeleteRequest.getException()!=null){
            throw stockMarketDeleteRequest.getException();
        }

        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(stockMarketDeleteRequest.getToken());
        if(tokenUser == null){
            throw new UnauthorizedResponse();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());
        StockMarket stockMarket = stockMarketRepository.getStockMarketById(id);
        if(user.getType()>2 || stockMarket.getUserId() == user.getUserId() ){

            stockMarketRepository.delete(stockMarket);
            jsonObject.put("message","right");
        }else{
            throw new ForbiddenException();
        }



    return jsonObject;
    }


}
