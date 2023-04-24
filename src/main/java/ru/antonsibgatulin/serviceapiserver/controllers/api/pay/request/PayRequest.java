package ru.antonsibgatulin.serviceapiserver.controllers.api.pay.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class PayRequest extends ARequest implements IRequest {

    public String data;
    public Integer type;

    public PayRequest() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public TypeResult getException() {
        if(type!= 0 && type!=1){
            return new BadRequest().getError();
        }
        if(getData()==null /*|| (data.length()!=11 && data.length()!=16)*/){
            return new BadRequest().getError();
        }
        if(checkToken()!=null){
            return checkToken();
        }
        return null;
    }
}
