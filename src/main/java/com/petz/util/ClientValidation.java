package com.petz.util;

import com.petz.entities.Client;
import com.petz.entities.Document;
import com.petz.entities.Pet;
import com.petz.exception.FieldValidationException;
import com.petz.exception.Validator;
import com.petz.util.i18n.MessageByLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.petz.exception.FieldErrorMessage.createFieldError;
import static com.petz.exception.Validator.ensureThat;

@Component
public class ClientValidation {

    @Autowired
    private MessageByLocaleService message;

    public void valid(Client client) {
        Validator badRequest = ensureThat()
                .assertNotEmpty(client.getName(),createFieldError("name", message.getMessage("client.name.empty")))
                .assertNotNull(client.getAddress(),createFieldError("address", message.getMessage("client.address.empty")))
                .assertNotEmpty(client.getAddress().getCity(),createFieldError("city", message.getMessage("client.city.empty")))
                .assertNotEmpty(client.getAddress().getCountry(),createFieldError("country", message.getMessage("client.country.empty")))
                .assertNotNull(client.getDocuments().stream().map(Document::getNumber),createFieldError("number", message.getMessage("client.document.empty")))
                .assertNotNull(client.getDocuments().stream().map(Document::getType),createFieldError("type", message.getMessage("client.type.empty")));
        getErros(badRequest);
    }

    public void notFound(Client client) {
        Validator badRequest = ensureThat()
                .assertFalse(client == null, createFieldError("client", message.getMessage("client.entity.empty")));
        if (badRequest.hasErrors()) {  throw new FieldValidationException(badRequest.errors(), HttpStatus.NOT_FOUND);}
    }

    private void getErros(Validator badRequest) {
        if (badRequest.hasErrors()) {  throw new FieldValidationException(badRequest.errors(), HttpStatus.BAD_REQUEST);}
    }

}
