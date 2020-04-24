package net.nicooliver.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeEntityNotFoundException extends RuntimeException {
    public EmployeeEntityNotFoundException(String message) {
        super(message);
    }
}
