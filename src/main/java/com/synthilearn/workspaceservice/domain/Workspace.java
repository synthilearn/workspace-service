package com.synthilearn.workspaceservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {

    private String name;
    private UUID id;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;
}
