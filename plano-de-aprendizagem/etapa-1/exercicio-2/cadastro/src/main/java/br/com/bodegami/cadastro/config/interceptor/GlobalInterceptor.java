package br.com.bodegami.cadastro.config.interceptor;

import br.com.bodegami.cadastro.config.exception.ResourceNotFoundException;
import br.com.bodegami.cadastro.config.interceptor.dto.ErrorField;
import br.com.bodegami.cadastro.config.interceptor.dto.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalInterceptor {

    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException ex, HttpServletRequest request) {
        StandardError error = getStandardError(NOT_FOUND.value(), request.getRequestURI(), ex.getMessage());
        return ResponseEntity
                .status(NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<StandardError> getMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        StandardError standardError = getStandardError(BAD_REQUEST.value(), request.getRequestURI(), ex.getMessage());

        List<ErrorField> errors = ex.getFieldErrors().stream()
                .map(field -> new ErrorField(field.getField(), field.getDefaultMessage()))
                .toList();

        standardError.setErrors(errors);
        return ResponseEntity.status(BAD_REQUEST).body(standardError);
    }

    private StandardError getStandardError(int status, String path, String error) {
        return new StandardError(LocalDateTime.now().toString(), status, path, error, null);
    }


}
