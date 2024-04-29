package com.synthilearn.workspaceservice.app.services;

import com.synthilearn.securestarter.AccessToken;
import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WorkareaTemplateService {

    Flux<WorkareaTemplate> getAll(AccessToken accessToken);
    Mono<WorkareaTemplate> findById(String type);
}
