package com.springbootrestapivalidation.springbootrestapivalidation.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllGeneralException(Exception exception, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception,
            WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Method Argument Validation Failed",
                exception.getBindingResult().toString());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
