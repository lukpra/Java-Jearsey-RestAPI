package pl.lukpra.resttable.errorresponses.exceptions;


import pl.lukpra.resttable.errorresponses.model.ExceptionMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserException extends WebApplicationException {
    public UserException(String message, String userMessage, String info) {
        super(Response.status(Response.Status.NOT_FOUND).
                entity(createExceptionMessage(message, userMessage, info))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }

    private static ExceptionMessage createExceptionMessage(String message, String userMessage, String info) {
        return new ExceptionMessage(message, userMessage, info);
    }
}
