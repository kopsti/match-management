package com.betting.sports.matchmanagement.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Matches repository.
 */
@Repository
public interface MatchesRepository extends JpaRepository<MatchModel, Long> {
}
