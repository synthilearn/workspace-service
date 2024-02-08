package com.synthilearn.workspaceservice.infra.persistence.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;
import java.util.UUID;

@Table("workspace")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceEntity implements Persistable<UUID> {

    @Id
    private UUID id;
    private String name;
    @Column("created_date")
    private ZonedDateTime createdDate;
    @Column("updated_date")
    private ZonedDateTime updatedDate;

    @Transient
    private boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
