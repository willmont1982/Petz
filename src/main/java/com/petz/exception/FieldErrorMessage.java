package com.petz.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorMessage {

    private String field;
    private String message;

    public static FieldErrorMessage createFieldError(String field, String message) {
        return new FieldErrorMessage(field, message);
    }

}
