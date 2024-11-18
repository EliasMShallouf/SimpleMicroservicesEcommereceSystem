package com.example.ecomm.user.service.api;

import com.example.ecomm.user.domain.model.exceptions.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingService extends ResponseEntityExceptionHandler {
    @ExceptionHandler({
        RuntimeException.class
    })
    protected ResponseEntity<Object> handleGeneralError(Exception ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                new ExceptionResponse(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }
}