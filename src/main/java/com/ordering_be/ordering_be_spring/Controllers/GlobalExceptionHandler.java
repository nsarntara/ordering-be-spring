package com.ordering_be.ordering_be_spring.Controllers;

import com.ordering_be.ordering_be_spring.Models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ErrorResponseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(ErrorResponseException ex) {


        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
