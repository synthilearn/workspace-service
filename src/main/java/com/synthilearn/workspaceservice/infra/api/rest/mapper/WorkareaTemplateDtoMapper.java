package com.synthilearn.workspaceservice.infra.api.rest.mapper;

import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import com.synthilearn.workspaceservice.infra.api.rest.dto.WorkareaTemplateDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkareaTemplateDtoMapper {

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<WorkareaTemplateDto> map(List<WorkareaTemplate> workareaTemplates);

    WorkareaTemplateDto map(WorkareaTemplate workareaTemplate);
}
