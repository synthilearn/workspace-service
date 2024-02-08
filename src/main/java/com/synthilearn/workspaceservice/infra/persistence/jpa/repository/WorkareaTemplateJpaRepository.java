package com.synthilearn.workspaceservice.infra.persistence.jpa.repository;

import com.synthilearn.workspaceservice.infra.persistence.jpa.entity.WorkareaTemplateEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkareaTemplateJpaRepository extends ReactiveCrudRepository<WorkareaTemplateEntity, String> {
}
