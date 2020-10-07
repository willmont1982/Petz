package com.petz.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandller extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {FieldValidationException.class})
    protected ResponseEntity<FieldErrorResponse> handleCbcValidationException(FieldValidationException exception, WebRequest request) {
        FieldErrorResponse fieldErrorResponse = new FieldErrorResponse(exception.getFieldErrorMessage());

        return new ResponseEntity<FieldErrorResponse>(fieldErrorResponse, exception.getHttpStatus());
    }
}
