package br.com.bodegami.cadastro.utils.exception;

public class UpdateUserIntegrityViolationException extends RuntimeException {

    public UpdateUserIntegrityViolationException(String message) {
        super(message);
    }
}
