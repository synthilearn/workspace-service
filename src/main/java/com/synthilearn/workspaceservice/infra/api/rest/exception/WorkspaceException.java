package com.synthilearn.workspaceservice.infra.api.rest.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class WorkspaceException extends GeneralException {

    public WorkspaceException(String message, HttpStatus status, Integer code) {
        super(message, status, code);
    }

    public static WorkspaceException notFoundById(UUID uuid) {
        return new WorkspaceException("Workspace not found with id: "+ uuid, HttpStatus.NOT_FOUND, 1000);
    }
}
