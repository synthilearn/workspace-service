package com.synthilearn.workspaceservice.app.repositories.impl;

import com.synthilearn.workspaceservice.app.mapper.WorkareaTemplateEntityMapper;
import com.synthilearn.workspaceservice.app.repositories.WorkareaTemplateRepository;
import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import com.synthilearn.workspaceservice.infra.persistence.jpa.repository.WorkareaTemplateJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkareaTemplateRepositoryImpl implements WorkareaTemplateRepository {

    private final WorkareaTemplateJpaRepository workareaTemplateJpaRepository;
    private final WorkareaTemplateEntityMapper workareaTemplateEntityMapper;

    @Override
    public Flux<WorkareaTemplate> findAll() {
        return workareaTemplateJpaRepository.findAll()
                .map(workareaTemplateEntityMapper::map);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<WorkareaTemplate> findByType(String type) {
        return workareaTemplateJpaRepository.findById(type)
                .map(workareaTemplateEntityMapper::map);
    }
}
