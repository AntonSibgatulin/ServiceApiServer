package ru.antonsibgatulin.serviceapiserver.include.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedResponse extends RuntimeException implements IError{

    public TypeResult getError(){
        return new TypeResult("UNAUTHORIZED",401,"UNAUTHORIZED");
    }
}
