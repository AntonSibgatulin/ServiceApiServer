package ru.antonsibgatulin.serviceapiserver.include;

import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;

public class ARequest {
    public String token;

    public Exception checkToken(){
        if (token == null){
            return new UnauthorizedResponse();
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
