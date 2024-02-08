package com.synthilearn.workspaceservice.infra.persistence.jpa.entity;


import com.synthilearn.workspaceservice.domain.TemplateStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("workarea_template")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkareaTemplateEntity implements Persistable<String> {

    @Id
    private String type;
    private String name;
    private TemplateStatus status;
    private String description;

    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return type;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
