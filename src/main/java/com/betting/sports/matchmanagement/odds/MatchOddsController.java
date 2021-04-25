package com.betting.sports.matchmanagement.odds;

import com.betting.sports.matchmanagement.common.AbstractCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Match odds controller.
 */
@RestController
@RequestMapping("odds")
@Slf4j
public class MatchOddsController extends AbstractCrudController<OddsModel> {

    private final OddsRepository repository;

    /**
     * Instantiates a new Match odds controller.
     *
     * @param repository the odds repository
     */
    @Autowired
    public MatchOddsController(final OddsRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<OddsModel, Long> repository() {
        return repository;
    }

}
