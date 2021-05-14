/* package */
package com.indexing.exception;

/* On-Demand Imports */

/* Specific Imports */
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Component that handles all RuntimeExceptions by mapping the exceptions
 * to the ExceptionMapper, implements ExceptionMapper<T> using RuntimeException
 * as the generic type.
 */
@Provider
public class RuntimeExceptionMapper
        implements ExceptionMapper<RuntimeException> {

    /* Data members */

    /* Constructors */

    /* Methods */

    /**
     * Method to handle any RuntimeException passed as a parameter
     * by returning the appropriate response object used to create HTTP Response.
     *
     * Response Status is always equal to 400, corresponding to a BAD REQUEST.
     * Type of Response is always plain text.
     * Content of Response is the message of the exception itself.
     *
     * @param exception RuntimeException to throw
     * @return Response object used to create HTTP Response
     */
    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
                .entity(exception.getMessage())
                .type("plain/text").build();
    }

}
