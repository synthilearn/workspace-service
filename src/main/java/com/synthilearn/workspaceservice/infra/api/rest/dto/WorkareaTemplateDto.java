package com.synthilearn.workspaceservice.infra.api.rest.dto;

import com.synthilearn.workspaceservice.domain.AvailableStatus;
import com.synthilearn.workspaceservice.domain.TemplateStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkareaTemplateDto {

    private String type;
    private String name;
    private TemplateStatus status;
    private AvailableStatus available;
    private String description;
}
