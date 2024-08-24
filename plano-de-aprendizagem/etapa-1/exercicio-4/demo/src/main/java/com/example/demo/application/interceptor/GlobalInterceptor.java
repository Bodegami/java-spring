package com.example.demo.application.interceptor;

import com.example.demo.application.interceptor.dto.ApiErrorResponse;
import com.example.demo.application.interceptor.dto.FieldErrorResponse;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.exception.TaskIntegrityViolationException;
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

    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private static final HttpStatus UNPROCESSABLE_ENTITY = HttpStatus.UNPROCESSABLE_ENTITY;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> getError(MethodArgumentNotValidException ex, HttpServletRequest request) {
        var errorResponse = getApiErrorResponse(BAD_REQUEST, request.getRequestURI(), ex.getMessage());
        List<FieldErrorResponse> errors = ex.getFieldErrors().stream().map(e -> new FieldErrorResponse(e.getField(), e.getDefaultMessage())).toList();
        errorResponse.setErrors(errors);

        return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> getError(ResourceNotFoundException ex, HttpServletRequest request) {
        var errorResponse = getApiErrorResponse(NOT_FOUND, request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(value = TaskIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> getError(TaskIntegrityViolationException ex, HttpServletRequest request) {
        var errorResponse = getApiErrorResponse(UNPROCESSABLE_ENTITY, request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    private ApiErrorResponse getApiErrorResponse(HttpStatus status, String uri, String error) {
        return new ApiErrorResponse(LocalDateTime.now().toString(), status.value(), uri, error, null);
    }

}
