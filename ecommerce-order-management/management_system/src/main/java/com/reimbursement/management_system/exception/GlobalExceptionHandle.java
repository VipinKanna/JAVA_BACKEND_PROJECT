package com.reimbursement.management_system.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.ResponseStatus;



@RestControllerAdvice
public class GlobalExceptionHandle {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String,String>> handleException(MethodArgumentNotValidException exception) {

        Map <String,String> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> { errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}