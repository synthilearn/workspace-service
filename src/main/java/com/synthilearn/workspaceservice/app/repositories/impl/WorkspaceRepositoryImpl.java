package com.synthilearn.workspaceservice.app.repositories.impl;

import com.synthilearn.workspaceservice.app.mapper.WorkspaceEntityMapper;
import com.synthilearn.workspaceservice.app.repositories.WorkspaceRepository;
import com.synthilearn.workspaceservice.domain.Workspace;
import com.synthilearn.workspaceservice.infra.api.rest.exception.WorkspaceException;
import com.synthilearn.workspaceservice.infra.persistence.jpa.repository.WorkspaceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WorkspaceRepositoryImpl implements WorkspaceRepository {

    private final WorkspaceJpaRepository workspaceJpaRepository;
    private final WorkspaceEntityMapper workspaceEntityMapper;

    @Override
    @Transactional
    public Mono<Void> create(Workspace workspace) {
        return workspaceJpaRepository.saveWithCustomId(workspaceEntityMapper.map(workspace));
    }

    @Override
    @Transactional
    public Mono<Workspace> updateName(String name, UUID workspaceId) {
        return workspaceJpaRepository.findById(workspaceId)
                .singleOptional()
                .flatMap(workspaceOpt -> {
                    var entity = workspaceOpt
                            .orElseThrow(() -> WorkspaceException.notFoundById(workspaceId));
                    entity.setName(name);
                    entity.setUpdatedDate(ZonedDateTime.now());
                    return workspaceJpaRepository.save(entity);
                })
                .map(workspaceEntityMapper::map);
    }

    @Override
    public Mono<Workspace> findById(UUID workspaceId) {
        return workspaceJpaRepository.findById(workspaceId)
                .switchIfEmpty(Mono.error(WorkspaceException.notFoundById(workspaceId)))
                .map(workspaceEntityMapper::map);
    }
}
