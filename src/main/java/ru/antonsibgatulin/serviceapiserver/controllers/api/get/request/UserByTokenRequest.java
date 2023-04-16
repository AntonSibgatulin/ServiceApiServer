package ru.antonsibgatulin.serviceapiserver.controllers.api.get.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;

public class UserByTokenRequest extends ARequest implements IRequest {

    public Long id_user;

    public UserByTokenRequest(String token, Long id_user) {
        this.token = token;
        this.id_user = id_user;
    }

    public UserByTokenRequest() {
    }



    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public Exception getException() {
      if(checkToken()!=null){
          return checkToken();
      }
        return null;
    }
}
