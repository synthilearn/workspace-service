package com.synthilearn.workspaceservice.infra.api.rest;

import com.synthilearn.commonstarter.GenericResponse;
import com.synthilearn.securestarter.AccessToken;
import com.synthilearn.workspaceservice.app.services.WorkareaTemplateService;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkareaTemplateDto;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkareaTemplatesResponse;
import com.synthilearn.workspaceservice.infra.api.rest.mapper.WorkareaTemplateDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workspace-service/v1/template")
public class WorkareaTemplateController {

    private final WorkareaTemplateService workareaTemplateService;
    private final WorkareaTemplateDtoMapper workareaTemplateDtoMapper;

    @GetMapping("/all")
    public Mono<GenericResponse<WorkareaTemplatesResponse>> getAll(AccessToken accessToken) {
        return workareaTemplateService.getAll(accessToken)
                .collectList()
                .map(template -> new WorkareaTemplatesResponse(workareaTemplateDtoMapper.map(template)))
                .map(GenericResponse::ok);
    }

    @GetMapping("/{type}")
    public Mono<GenericResponse<WorkareaTemplateDto>> getById(@PathVariable String type) {
        return workareaTemplateService.findById(type)
                .map(workareaTemplateDtoMapper::map)
                .map(GenericResponse::ok);
    }
}
