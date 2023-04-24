package ru.antonsibgatulin.serviceapiserver.include.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundRequest extends RuntimeException implements IError{
    public TypeResult getError(){
        return new TypeResult("not_found",404,"not_found");
    }
}
