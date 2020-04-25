package net.nicooliver.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeDataServiceException extends RuntimeException {
    public EmployeeDataServiceException(String message) {
        super(message);
    }
}
