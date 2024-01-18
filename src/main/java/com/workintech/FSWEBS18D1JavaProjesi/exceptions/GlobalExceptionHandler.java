package com.workintech.FSWEBS18D1JavaProjesi.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException burgerException){
        BurgerErrorResponse response = new BurgerErrorResponse(burgerException.getMessage());
        log.error("BurgerException occured!",burgerException.getMessage());
        return new ResponseEntity<>(response,burgerException.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception){
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage());
        log.error("Exception occured!",exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
