package com.synthilearn.workspaceservice.app.services.impl;

import com.synthilearn.securestarter.AccessToken;
import com.synthilearn.workspaceservice.app.repositories.WorkareaTemplateRepository;
import com.synthilearn.workspaceservice.app.services.WorkareaTemplateService;
import com.synthilearn.workspaceservice.domain.AvailableStatus;
import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import com.synthilearn.workspaceservice.infra.adapter.client.WorkareaClient;
import com.synthilearn.workspaceservice.infra.api.rest.dto.Workarea;

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
    private final WorkareaClient workareaClient;

    @Override
    public Flux<WorkareaTemplate> getAll(AccessToken accessToken) {
        return workareaClient.getAllWorkareas(accessToken)
                .flatMapMany(workareas -> workareaTemplateRepository.findAll()
                        .map(workareaTemplate -> {
                            if (workareas.stream().map(Workarea::getType).toList().contains(workareaTemplate.getType())) {
                                workareaTemplate.setAvailable(AvailableStatus.USED);
                            }
                            return workareaTemplate;
                        }));
    }

    @Override
    public Mono<WorkareaTemplate> findById(String type) {
        return workareaTemplateRepository.findByType(type);
    }
}
