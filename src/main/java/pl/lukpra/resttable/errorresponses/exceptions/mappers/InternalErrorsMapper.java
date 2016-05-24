package pl.lukpra.resttable.errorresponses.exceptions.mappers;


import pl.lukpra.resttable.errorresponses.model.ExceptionMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalErrorsMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        if(WebApplicationException.class.isAssignableFrom(throwable.getClass())) {
            WebApplicationException exc = (WebApplicationException) throwable;

            return Response.status(exc.getResponse().getStatus())
                    .entity(createExceptionMessage(exc))
                    .type(MediaType.APPLICATION_JSON)
                    .build();

        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createExceptionMessage(throwable))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    private ExceptionMessage createExceptionMessage(Throwable throwable) {
        return new ExceptionMessage("Internal server error.  " + throwable.getMessage(),
                "Try again later.",
                "http://app_link/erorrs/internal");
    }

    private ExceptionMessage createExceptionMessage(WebApplicationException exc) {
        return new ExceptionMessage(exc.getMessage(),
                "Internal server error, try again later",
                "http://app_link/erorrs/internal");
    }
}
