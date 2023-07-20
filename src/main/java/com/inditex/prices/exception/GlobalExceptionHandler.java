package com.inditex.prices.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        PriceNotFound.class
    })
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ResponseEntity<String> handleNotFound(PriceNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }
}
