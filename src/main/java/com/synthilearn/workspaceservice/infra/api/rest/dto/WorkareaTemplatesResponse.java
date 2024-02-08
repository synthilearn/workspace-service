package com.synthilearn.workspaceservice.infra.api.rest.dto;

import com.synthilearn.workspaceservice.domain.WorkareaTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkareaTemplatesResponse {

    private List<WorkareaTemplateDto> templates;
}
