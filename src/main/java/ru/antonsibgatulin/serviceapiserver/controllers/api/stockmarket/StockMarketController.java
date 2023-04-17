package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request.StockMarketRequestModel;
import ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request.StockMarketRequestModelMapper;
import ru.antonsibgatulin.serviceapiserver.include.StaticContent;
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

        stockMarket = stockMarketRepository.save(stockMarket);
        stockMarketRepository.flush();
        return stockMarket;
    }

}
