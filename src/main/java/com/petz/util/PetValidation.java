package com.petz.util;

import com.petz.entities.Pet;
import com.petz.exception.Validator;
import com.petz.exception.FieldValidationException;
import com.petz.util.i18n.MessageByLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.petz.exception.Validator.ensureThat;
import static com.petz.exception.FieldErrorMessage.createFieldError;

@Component
public class PetValidation {

    @Autowired
    private MessageByLocaleService message;

    public void valid(Pet pet) {
        Validator badRequest = ensureThat()
                .assertNotNull(pet.getClient().getId(),createFieldError("client", message.getMessage("pet.client.empty")))
                .assertNotEmpty(pet.getName(),createFieldError("name", message.getMessage("pet.name.empty")))
                .assertNotNull(pet.getAge(),createFieldError("age", message.getMessage("pet.age.empty")));
        getErros(badRequest);
    }

    public void notFound(Pet pet) {
        Validator badRequest = ensureThat()
                .assertFalse(pet == null, createFieldError("pet", message.getMessage("pet.entity.empty")));
        if (badRequest.hasErrors()) {  throw new FieldValidationException(badRequest.errors(), HttpStatus.NOT_FOUND);}
    }

    private void getErros(Validator badRequest) {
        if (badRequest.hasErrors()) {  throw new FieldValidationException(badRequest.errors(), HttpStatus.BAD_REQUEST);}
    }

}
