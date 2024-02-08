package com.synthilearn.workspaceservice.infra.api.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {

    private String name;
    @NotNull
    private UUID id;
}
