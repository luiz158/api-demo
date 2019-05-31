package com.example.apidemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@RestController
@ControllerAdvice
public class CustomHandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundEntityException.class})
    public final ResponseEntity<ErrorResponse> handleInvalidRequestModeCardException(RuntimeException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @AllArgsConstructor
    class ErrorResponse {

        @Getter
        private Date timestamp;
        @Getter
        private String message;
        @Getter
        private String details;

    }

}
