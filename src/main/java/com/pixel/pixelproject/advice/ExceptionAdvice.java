package com.pixel.pixelproject.advice;

import com.pixel.pixelproject.exception.ProductNotFoundException;
import com.pixel.pixelproject.exception.data.ExceptionResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Andrius Baltrunas
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingProductNotFound(ProductNotFoundException exception) {
        return new ExceptionResponse(String.format("Product %s not found", exception.getId()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingEmptyResult(EmptyResultDataAccessException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}