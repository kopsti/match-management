package com.betting.sports.matchmanagement.common;

import org.springframework.data.repository.CrudRepository;

/**
 * The interface CRUD controller.
 *
 * @param <M> the type parameter for Model
 */
public interface CrudController<M> {

    /**
     * Repository CRUD.
     *
     * @return the crud repository
     */
    CrudRepository<M, Long> repository();

}
