package com.synthilearn.workspaceservice.app.repositories;

import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WorkareaTemplateRepository {
    Flux<WorkareaTemplate> findAll();

    Mono<WorkareaTemplate> findByType(String type);
}
