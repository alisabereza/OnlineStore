package com.berezovska.store.controller.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data
class ErrorMessage {
    private String field;
    private String error;

    public ErrorMessage(String field, String error) {
        this.field = field;
        this.error = error;
    }
}

