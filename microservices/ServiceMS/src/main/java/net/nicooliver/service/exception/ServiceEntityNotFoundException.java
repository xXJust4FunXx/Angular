package net.nicooliver.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ServiceEntityNotFoundException extends RuntimeException {
    public ServiceEntityNotFoundException(String message) {
        super(message);
    }
}
