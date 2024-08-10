package br.com.bodegami.cadastro.utils.exception.interceptor;

import br.com.bodegami.cadastro.utils.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.utils.exception.UpdateUserIntegrityViolationException;
import br.com.bodegami.cadastro.utils.exception.interceptor.dto.ErrorField;
import br.com.bodegami.cadastro.utils.exception.interceptor.dto.ResponseError;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalInterceptor {

    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private static final HttpStatus UNPROCESSABLE_ENTITY = HttpStatus.UNPROCESSABLE_ENTITY;
    private static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseError> getMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        var responseError = getResponseError(BAD_REQUEST, request.getRequestURI(), ex.getMessage());

        List<ErrorField> errors = ex.getFieldErrors().stream()
                .map(e -> new ErrorField(e.getField(), e.getDefaultMessage()))
                .toList();

        responseError.setErrors(errors);

        return ResponseEntity.status(BAD_REQUEST).body(responseError);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ResponseError> getResourceNotFoundException(
            ResourceNotFoundException ex, HttpServletRequest request) {

        var responseError = getResponseError(NOT_FOUND, request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ResponseError> getEntityNotFoundException(
            EntityNotFoundException ex, HttpServletRequest request) {

        var responseError = getResponseError(NOT_FOUND, request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(value = {UpdateUserIntegrityViolationException.class})
    public ResponseEntity<ResponseError> getUpdateUserIntegrityViolationException(
            UpdateUserIntegrityViolationException ex, HttpServletRequest request) {

        var responseError = getResponseError(UNPROCESSABLE_ENTITY, request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(responseError);
    }

    private ResponseError getResponseError(HttpStatus status, String uri, String error) {
        return new ResponseError(Instant.now().toString(), status.value(), uri, error, null);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<ResponseError> getIllegalStateException(
            IllegalStateException ex, HttpServletRequest request) {

        var responseError = getResponseError(INTERNAL_SERVER_ERROR, request.getRequestURI(), "Internal Server Error");

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(responseError);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseError> getException(
            Exception ex, HttpServletRequest request) {

        var responseError = getResponseError(INTERNAL_SERVER_ERROR, request.getRequestURI(), "Internal Server Error");

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(responseError);
    }

}
