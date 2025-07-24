package com.java.app.component;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.java.app.util.AppUtil.*;

@RestControllerAdvice
public class AppExceptionHandler {

    // Handle validation errors (e.g., @NotBlank, @Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        /*
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        */
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation failed", null);
        // return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
    }

    // Handle illegal argument exceptions (e.g., invalid enum values)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
    }

    // Handle database-related exceptions
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Database error: " + ex.getMessage(), null);
    }

    // Handle all other exceptions (catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", null);
    }

    private ResponseEntity<String> buildErrorResponse(HttpStatus status, String message, Map<String, String> details) {
        return getFinalizedResponse(status.value(), getNewUUID(), status.name(), message);

        /*
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("error", status.getReasonPhrase());
        response.put("message", message);
        if (details != null && !details.isEmpty()) {
            response.put("details", details);
        }
        response.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(response, status);
        */
    }
}
