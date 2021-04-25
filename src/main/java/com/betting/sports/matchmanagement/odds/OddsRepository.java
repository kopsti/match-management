package com.betting.sports.matchmanagement.odds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Odds repository.
 */
@Repository
interface OddsRepository extends JpaRepository<OddsModel, Long> {
}
