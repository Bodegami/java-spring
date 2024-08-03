package br.com.bodegami.cadastro.utils;

import br.com.bodegami.cadastro.domain.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.domain.exception.dto.ErrorField;
import br.com.bodegami.cadastro.domain.exception.dto.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalInterceptor {

    private final int BAD_REQUEST = HttpStatus.BAD_REQUEST.value();
    private final int UNPROCESSABLE_ENTITY = HttpStatus.UNPROCESSABLE_ENTITY.value();
    private final int NOT_FOUND = HttpStatus.NOT_FOUND.value();

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<StandardError> getMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        StandardError standardError = getStandardError(BAD_REQUEST, request.getRequestURI(), ex.getMessage());

        List<ErrorField> errors = ex.getFieldErrors().stream()
                .map(field -> new ErrorField(field.getField(), field.getDefaultMessage()))
                .toList();

        standardError.setErrors(errors);
        return ResponseEntity.status(BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<StandardError> getSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex,
                                                                        HttpServletRequest request) {
        StandardError standardError = getStandardError(UNPROCESSABLE_ENTITY, request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(standardError);
    }

    private StandardError getStandardError(int status, String path, String error) {
        return new StandardError(LocalDateTime.now().toString(), status, path, error, null);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<StandardError> getResourceNotFoundException(ResourceNotFoundException ex,
                                                                                     HttpServletRequest request) {
        StandardError standardError = getStandardError(NOT_FOUND, request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(NOT_FOUND).body(standardError);
    }
}
