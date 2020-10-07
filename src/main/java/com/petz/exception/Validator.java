package com.petz.exception;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator<T> {

    List<T> erros = Collections.EMPTY_LIST;

    public Validator() {
        erros = new ArrayList<T>();
    }

    public static Validator ensureThat() {
        return new Validator();
    }

    public Validator assertNotNull(Object value, T errorMessage) {
        if (value == null) {
            erros.add(errorMessage);
        }

        return this;
    }

    public Validator assertNotEmpty(String value, T errorMessage) {
        if (StringUtils.isEmpty(value)) {
            erros.add(errorMessage);
        }
        return this;
    }

    public Validator assertTrue(boolean value, T errorMessage) {
        if (!value) {
            erros.add(errorMessage);
        }

        return this;
    }

    public Validator assertFalse(boolean value, T errorMessage) {
        if (value) {
            erros.add(errorMessage);
        }

        return this;
    }

    public boolean hasErrors() {
        return !erros.isEmpty();
    }

    public List<T> errors() {
        return erros;
    }
}