package com.synthilearn.workspaceservice.infra.api.rest.dto;

import java.util.UUID;

import com.synthilearn.workspaceservice.domain.WorkareaStatus;
import com.synthilearn.workspaceservice.domain.WorkareaType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Workarea {

    private UUID id;
    private UUID workspaceId;
    private String name;
    private WorkareaStatus status;
    private WorkareaType type;
}