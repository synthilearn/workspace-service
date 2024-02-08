package com.synthilearn.workspaceservice.infra.api.rest.mapper;

import com.synthilearn.workspaceservice.domain.Workspace;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkspaceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceDtoMapper {

    WorkspaceDto map(Workspace workspace);
    Workspace map(WorkspaceDto workspace);
}
