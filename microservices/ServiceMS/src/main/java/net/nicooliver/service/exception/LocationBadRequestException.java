package net.nicooliver.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LocationBadRequestException extends RuntimeException {
    public LocationBadRequestException(String message) {
        super(message);
    }
}
