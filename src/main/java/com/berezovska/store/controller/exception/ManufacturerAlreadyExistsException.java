package com.berezovska.store.controller.exception;

public class ManufacturerAlreadyExistsException extends RuntimeException {
    public ManufacturerAlreadyExistsException(String message) {
        super(message);
    }
}
