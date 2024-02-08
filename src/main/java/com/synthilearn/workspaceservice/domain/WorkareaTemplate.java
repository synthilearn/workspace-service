package com.synthilearn.workspaceservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkareaTemplate {

    private String type;
    private String name;
    private TemplateStatus status;
    private AvailableStatus available;
    private String description;
}
