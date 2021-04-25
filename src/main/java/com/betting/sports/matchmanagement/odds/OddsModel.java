package com.betting.sports.matchmanagement.odds;

import com.betting.sports.matchmanagement.common.AbstractModel;
import com.betting.sports.matchmanagement.matches.MatchModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The type Odds model.
 */
@Entity
@Table(name = "odds")
@Data
@EqualsAndHashCode(callSuper = true, exclude = "match")
public class OddsModel extends AbstractModel {

    @Column(name = "specifier")
    private String specifier;

    @Column(name = "odd")
    private Double odd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    @JsonBackReference
    private MatchModel match;

}
