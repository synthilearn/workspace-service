package com.synthilearn.workspaceservice.app.mapper;

import com.synthilearn.workspaceservice.domain.Workspace;
import com.synthilearn.workspaceservice.infra.persistence.jpa.entity.WorkspaceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceEntityMapper {
    WorkspaceEntity map(Workspace workspace);
    Workspace map(WorkspaceEntity workspace);
}
