package ru.antonsibgatulin.serviceapiserver.include.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY,reason = "the number of ads created per day exceeds 5")
public class RestrictionOnCreateObjects extends RuntimeException {
}
