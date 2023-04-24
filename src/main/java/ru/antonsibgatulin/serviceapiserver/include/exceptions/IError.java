package ru.antonsibgatulin.serviceapiserver.include.exceptions;

import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public interface IError {
    public TypeResult getError();
}
