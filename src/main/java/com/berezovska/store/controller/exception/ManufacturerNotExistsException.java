package com.berezovska.store.controller.exception;

public class ManufacturerNotExistsException extends RuntimeException {
    public ManufacturerNotExistsException (String message) {
        super(message);
    }
}

