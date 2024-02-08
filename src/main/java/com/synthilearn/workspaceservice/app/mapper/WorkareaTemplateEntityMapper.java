package com.synthilearn.workspaceservice.app.mapper;

import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import com.synthilearn.workspaceservice.infra.persistence.jpa.entity.WorkareaTemplateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkareaTemplateEntityMapper {

    WorkareaTemplateEntity map(WorkareaTemplate workareaTemplate);

    WorkareaTemplate map(WorkareaTemplateEntity workareaTemplate);
}
