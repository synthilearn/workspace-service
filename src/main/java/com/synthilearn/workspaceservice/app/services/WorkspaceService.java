package com.synthilearn.workspaceservice.app.services;

import com.synthilearn.workspaceservice.domain.Workspace;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceNameRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkspaceService {

    Mono<Void> create(Workspace workspace);

    Mono<Workspace> updateName(WorkspaceNameRequest request, UUID workspaceId);

    Mono<Workspace> findById(UUID workspaceId);
}
