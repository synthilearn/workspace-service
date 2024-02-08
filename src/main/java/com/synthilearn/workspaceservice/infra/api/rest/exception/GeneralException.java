package com.synthilearn.workspaceservice.infra.api.rest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class GeneralException extends RuntimeException{

    private HttpStatus status;
    private Integer code;

    public GeneralException(String message, HttpStatus status, Integer code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public GeneralException(String message) {
        super(message);
    }
}
