/* package */
package com.indexing.exception;

/* On-Demand Imports */

/* Specific Imports */

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Class that handles query exceptions,
 * extends Exception.
 */

public class InvalidQueryException
        extends Exception {
    /* Data members */

    /* Constructors */

    /**
     *
     * @param message String represents message of the exception
     */
    public InvalidQueryException(String message) {
        super(message);
    }

    /* Methods */

}