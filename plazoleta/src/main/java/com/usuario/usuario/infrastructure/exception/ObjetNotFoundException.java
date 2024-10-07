package com.usuario.usuario.infrastructure.exception;

public class ObjetNotFoundException extends RuntimeException {
    public ObjetNotFoundException(String message) {
        super(message);
    }
}