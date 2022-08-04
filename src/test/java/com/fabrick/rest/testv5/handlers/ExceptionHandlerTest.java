package com.fabrick.rest.testv5.handlers;

import com.fabrick.rest.testv5.exceptions.GenericError;
import com.fabrick.rest.testv5.exceptions.GenericException;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionHandlerTest {
    private final ExceptionHandler errorHandler = new ExceptionHandler();

    @Test
    public void ErrorHandler_GenericException_OK() {
        //arrange
        GenericException exception = new GenericException("query", "String");
        //act
        ResponseEntity<GenericError> sut = errorHandler.handleGenericException(exception);
        //assert
        assertThat(sut).isNotNull();

    }
}
