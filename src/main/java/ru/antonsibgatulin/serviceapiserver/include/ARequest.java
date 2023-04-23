package ru.antonsibgatulin.serviceapiserver.include;

import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class ARequest {
    public String token;

    public TypeResult checkToken(){
        if (token == null){
            return new UnauthorizedResponse().getError();
        }else{
            return null;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
