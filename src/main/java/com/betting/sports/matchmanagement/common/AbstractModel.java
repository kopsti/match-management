package com.betting.sports.matchmanagement.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The class for the Abstract model.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue
    private long id;

}
