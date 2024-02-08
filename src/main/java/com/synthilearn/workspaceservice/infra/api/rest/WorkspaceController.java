package com.synthilearn.workspaceservice.infra.api.rest;

import com.synthilearn.commonstarter.GenericResponse;
import com.synthilearn.securestarter.AccessToken;
import com.synthilearn.workspaceservice.app.services.WorkspaceService;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceDto;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceNameRequest;
import com.synthilearn.workspaceservice.infra.api.rest.mapper.WorkspaceDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workspace-service/v1/workspace")
public class WorkspaceController {

    private final WorkspaceService workspaceService;
    private final WorkspaceDtoMapper workspaceDtoMapper;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<GenericResponse<WorkspaceDto>> create(@RequestBody @Valid WorkspaceDto workspaceDto) {
        workspaceService.create(workspaceDtoMapper.map(workspaceDto))
                .subscribe();
        return Mono.just(GenericResponse.ok());
    }

    @PatchMapping
    public Mono<GenericResponse<WorkspaceDto>> updateName(@RequestBody @Valid WorkspaceNameRequest request,
                                                          AccessToken accessToken) {
        return workspaceService.updateName(request, accessToken.getId())
                .map(workspaceDtoMapper::map)
                .map(GenericResponse::ok);
    }

    @GetMapping
    public Mono<GenericResponse<WorkspaceDto>> findById(AccessToken accessToken) {
        return workspaceService.findById(accessToken.getId())
                .map(workspaceDtoMapper::map)
                .map(GenericResponse::ok);
    }
}
