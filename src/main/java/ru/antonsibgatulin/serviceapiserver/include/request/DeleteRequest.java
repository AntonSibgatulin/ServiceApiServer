package ru.antonsibgatulin.serviceapiserver.include.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class DeleteRequest extends ARequest implements IRequest {

    @Override
    public TypeResult getException() {

        return null;
    }
}
