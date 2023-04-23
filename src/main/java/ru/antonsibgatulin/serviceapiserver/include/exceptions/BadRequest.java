package ru.antonsibgatulin.serviceapiserver.include.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException implements IError{
    public String error=null;
    public TypeResult getError(){
        return new TypeResult("bad_request",400,"bad_request");
    }
}
