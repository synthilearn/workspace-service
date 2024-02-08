package com.synthilearn.workspaceservice.infra.persistence.jpa.repository;

import com.synthilearn.workspaceservice.infra.persistence.jpa.entity.WorkspaceEntity;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface WorkspaceJpaRepository extends ReactiveCrudRepository<WorkspaceEntity, UUID> {
    @Modifying
    @Query(value = "INSERT INTO workspace (id, name, created_date, updated_date) VALUES (:#{#entity.id}, :#{#entity.name}, :#{#entity.createdDate}, :#{#entity.updatedDate})")
    Mono<Void> saveWithCustomId(WorkspaceEntity entity);
}
