package com.berezovska.store.controller.exception;

public class ManufacturerAlreadyExistsError extends RuntimeException {
    public ManufacturerAlreadyExistsError(String message) {
        super(message);
    }
}
