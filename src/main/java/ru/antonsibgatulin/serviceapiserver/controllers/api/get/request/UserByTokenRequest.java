package ru.antonsibgatulin.serviceapiserver.controllers.api.get.request;

import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;

public class UserByTokenRequest implements IRequest {
    public String token;
    public Long id_user;

    public UserByTokenRequest(String token, Long id_user) {
        this.token = token;
        this.id_user = id_user;
    }

    public UserByTokenRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public Exception getException() {
        if(token==null){
            return new BadRequest();
        }
        return null;
    }
}
