package ru.antonsibgatulin.serviceapiserver.controllers.api.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "user authentication failed")
public class UserPasswordNotValid extends RuntimeException{
    @Override
    public String toString() {
        return "UserPasswordNotValid{}";
    }
}
