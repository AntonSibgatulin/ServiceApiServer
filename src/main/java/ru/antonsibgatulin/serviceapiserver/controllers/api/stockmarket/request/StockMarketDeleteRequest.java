package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class StockMarketDeleteRequest extends ARequest implements IRequest {


    @Override
    public TypeResult getException() {
        if(checkToken()!=null){
            return checkToken();
        }


        return null;
    }
}
