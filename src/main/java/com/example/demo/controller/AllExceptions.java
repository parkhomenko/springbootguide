package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AllExceptions extends ResponseEntityExceptionHandler {

  /*
  @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Runtime exception occured")
  @ExceptionHandler(RuntimeException.class)
  protected String handleConflict(HttpServletRequest request, RuntimeException ex) {
    return "{\"some\": \"someError\"}";
  }
  */

  @ExceptionHandler(RuntimeException.class)
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "{\\\"some\\\": \\\"someError\\\"}";
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    return handleExceptionInternal(ex, bodyOfResponse,
        httpHeaders, HttpStatus.OK, request);
  }
}
