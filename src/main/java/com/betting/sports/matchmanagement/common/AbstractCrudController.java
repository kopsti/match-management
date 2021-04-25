package com.betting.sports.matchmanagement.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The Abstract Controller for CRUD operations.
 *
 * @param <M> the type parameter for Model
 */
@Slf4j
public abstract class AbstractCrudController<M extends AbstractModel> implements CrudController<M> {

    /**
     * Create an entity.
     *
     * @param model the model to be created
     * @return the entity that was created
     */
    @PostMapping
    public ResponseEntity<M> create(@RequestBody final M model) {
        log.info("Model of type {} to be created {}", model.getClass().getName(), model);
        final M createdModel = repository().save(model);
        log.info("Model of type {} created, with id {}", createdModel.getClass().getName(), createdModel.getId());

        return ResponseEntity.created(
            MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(createdModel.getId())
                .toUri()).body(createdModel);
    }

    /**
     * Retrieve an entity by its id.
     *
     * @param id the entity's id
     * @return the entity that was retrieved
     */
    @GetMapping("{id}")
    public ResponseEntity<M> retrieveById(@PathVariable final long id) {
        final String repositoryName = repository().getClass().getName();
        log.info("Retrieving model with id {} from {}", id, repositoryName);

        return ResponseEntity.ok(repository().findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Model with id " + id + " not found in " + repositoryName)));
    }

    /**
     * Retrieve all entities.
     *
     * @return the entities that were retrieved
     */
    @GetMapping
    public ResponseEntity<List<M>> retrieveAll() {
        final String repositoryName = repository().getClass().getName();
        log.info("Retrieving all models available from {}", repositoryName);

        return ResponseEntity.ok(StreamSupport
            .stream(repository().findAll().spliterator(), false)
            .collect(Collectors.toList()));
    }

    /**
     * Update an entity.
     *
     * @param id    the entity's id
     * @param model the model with the updated values for the entity
     * @return the entity that was updated
     */
    @PutMapping("{id}")
    public ResponseEntity<M> update(@PathVariable final long id, @RequestBody final M model) {
        log.info("Updating model of type {} with id {}", model.getClass().getName(), id);

        return ResponseEntity.ok(repository().save(model));
    }

    /**
     * Delete an entity by its id.
     *
     * @param id the entity's id
     * @return the acknowledgment response
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable final long id) {
        final String repositoryName = repository().getClass().getName();
        log.info("Deleting model with id {} from repository {}", id, repositoryName);
        repository().deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
