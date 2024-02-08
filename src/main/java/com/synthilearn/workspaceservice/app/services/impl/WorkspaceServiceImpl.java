package com.synthilearn.workspaceservice.app.services.impl;

import com.synthilearn.workspaceservice.app.repositories.WorkspaceRepository;
import com.synthilearn.workspaceservice.app.services.WorkspaceService;
import com.synthilearn.workspaceservice.domain.Workspace;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceNameRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Override
    public Mono<Void> create(Workspace workspace) {
        return workspaceRepository.create(enrichWorkspaceDates(workspace));
    }

    @Override
    public Mono<Workspace> updateName(WorkspaceNameRequest request, UUID workspaceId) {
        return workspaceRepository.updateName(request.getName(), workspaceId);
    }

    @Override
    public Mono<Workspace> findById(UUID workspaceId) {
        return workspaceRepository.findById(workspaceId);
    }

    private Workspace enrichWorkspaceDates(Workspace workspace) {
        return workspace.toBuilder()
                .createdDate(ZonedDateTime.now())
                .updatedDate(ZonedDateTime.now())
                .build();
    }
}
