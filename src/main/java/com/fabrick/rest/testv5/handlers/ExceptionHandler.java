package com.fabrick.rest.testv5.handlers;

import com.fabrick.rest.testv5.exceptions.GenericError;
import com.fabrick.rest.testv5.exceptions.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = GenericException.class)
    public ResponseEntity<GenericError> handleGenericException(GenericException exception) {
        GenericError genericError = new GenericError(exception.getCode(), exception.getMessage());
        return new ResponseEntity<>(genericError, HttpStatus.BAD_REQUEST);
    }
}
