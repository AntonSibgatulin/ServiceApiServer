package ru.antonsibgatulin.serviceapiserver.controllers.api.reg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException{
    public String error=null;
}