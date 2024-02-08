package com.synthilearn.workspaceservice.infra.api.rest.exception.handler;

import com.synthilearn.commonstarter.GenericResponse;
import com.synthilearn.workspaceservice.infra.api.rest.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<GenericResponse<?>> handle(WebExchangeBindException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return Mono.just(GenericResponse.validError(errors));
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Mono<GenericResponse<Void>>> handle(GeneralException e) {
        return ResponseEntity.status(e.getStatus())
                .body(Mono.just(GenericResponse.error(e.getCode(), e.getMessage())));
    }
}
