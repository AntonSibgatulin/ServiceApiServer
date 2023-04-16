package ru.antonsibgatulin.serviceapiserver.controllers.api.auth.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequest {


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
}
