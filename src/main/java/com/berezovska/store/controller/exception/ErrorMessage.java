package com.berezovska.store.controller.exception;

import lombok.Data;

public @Data
class ErrorMessage {
    private String field;
    private String error;
}