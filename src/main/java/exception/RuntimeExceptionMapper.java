package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/10/2021
 * Time: 3:57 PM
 * Package: exception
 */

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {
        return Response.status(400).entity(e.getMessage()).type("plain/text").build();
    }
}