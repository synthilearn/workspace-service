package com.synthilearn.workspaceservice.app.repositories;

import com.synthilearn.workspaceservice.domain.Workspace;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkspaceRepository {

    Mono<Void> create(Workspace workspace);

    Mono<Workspace> updateName(String name, UUID workspaceId);

    Mono<Workspace> findById(UUID workspaceId);
}
