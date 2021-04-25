package com.betting.sports.matchmanagement.matches;

import com.betting.sports.matchmanagement.common.AbstractCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Matches controller.
 */
@RestController
@RequestMapping("matches")
@Slf4j
public class MatchesController extends AbstractCrudController<MatchModel> {

    private final MatchesRepository repository;

    /**
     * Instantiates a new Matches controller.
     *
     * @param repository the repository
     */
    @Autowired
    public MatchesController(final MatchesRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<MatchModel, Long> repository() {
        return repository;
    }

}
