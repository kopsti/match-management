package com.betting.sports.matchmanagement.common;

/**
 * The type Match not found exception.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
