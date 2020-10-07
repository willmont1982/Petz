package com.petz.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldValidationException extends RuntimeException {

    private List<FieldErrorMessage> fieldErrorMessage;
    private HttpStatus httpStatus;

}
