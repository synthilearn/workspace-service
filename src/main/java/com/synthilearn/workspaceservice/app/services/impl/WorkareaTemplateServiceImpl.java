package com.synthilearn.workspaceservice.app.services.impl;

import com.synthilearn.workspaceservice.app.repositories.WorkareaTemplateRepository;
import com.synthilearn.workspaceservice.app.services.WorkareaTemplateService;
import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkareaTemplateServiceImpl implements WorkareaTemplateService {

    private final WorkareaTemplateRepository workareaTemplateRepository;

    @Override
    public Flux<WorkareaTemplate> getAll() {
        return workareaTemplateRepository.findAll();
    }

    @Override
    public Mono<WorkareaTemplate> findById(String type) {
        return workareaTemplateRepository.findByType(type);
    }
}
