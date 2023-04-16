package ru.antonsibgatulin.serviceapiserver.controllers.api.auth.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;

@Data
public class AuthRequest implements IRequest {


    @NotNull
    public String login;
    @NotNull
    public String password;

    public String token;


    public AuthRequest(String login, String password, String token) {
        this.login = login;
        this.password = password;
        this.token = token;
    }

    public AuthRequest() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Exception getException() {
        if (login == null || password==null){
            return new BadRequest();
        }
        return null;
    }
}
