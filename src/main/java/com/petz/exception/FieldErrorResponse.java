package com.petz.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorResponse {

    @JsonProperty("erros")
    private List<FieldErrorMessage> fieldErrorMessages;
}
