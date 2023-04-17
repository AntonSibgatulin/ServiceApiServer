package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;

public class StockMarketDeleteRequest extends ARequest implements IRequest {


    @Override
    public Exception getException() {
        if(checkToken()!=null){
            return checkToken();
        }


        return null;
    }
}
