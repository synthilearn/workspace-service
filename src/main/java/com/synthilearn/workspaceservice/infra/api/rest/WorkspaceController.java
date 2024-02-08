package com.synthilearn.workspaceservice.infra.api.rest;

import com.synthilearn.commonstarter.GenericResponse;
import com.synthilearn.workspaceservice.app.services.WorkspaceService;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceDto;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceNameRequest;
import com.synthilearn.workspaceservice.infra.api.rest.mapper.WorkspaceDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

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

    @PatchMapping("/{workspaceId}")
    public Mono<GenericResponse<WorkspaceDto>> updateName(@RequestBody @Valid WorkspaceNameRequest request,
                                                          @PathVariable UUID workspaceId) {
        return workspaceService.updateName(request, workspaceId)
                .map(workspaceDtoMapper::map)
                .map(GenericResponse::ok);
    }

    @GetMapping("/{workspaceId}")
    public Mono<GenericResponse<WorkspaceDto>> findById(@PathVariable UUID workspaceId) {
        return workspaceService.findById(workspaceId)
                .map(workspaceDtoMapper::map)
                .map(GenericResponse::ok);
    }
}
