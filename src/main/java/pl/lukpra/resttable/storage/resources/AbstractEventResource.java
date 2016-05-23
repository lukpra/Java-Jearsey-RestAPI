package pl.lukpra.resttable.storage.resources;

import com.wordnik.swagger.annotations.ApiOperation;
import pl.lukpra.resttable.storage.database.EventDatabase;
import pl.lukpra.resttable.storage.model.Event;
import pl.lukpra.resttable.errorresponses.exceptions.UserException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Collection;

public abstract class AbstractEventResource {

    protected abstract EventDatabase getDatabase();

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get events collection", notes = "Get users collection", response = Event.class, responseContainer = "LIST" )
    public Collection<Event> list(){
        return getDatabase().getEvents();
    }

    @Path("/{eventId}")
    @ApiOperation(value = "Get event by id", notes = "Get event by id", response = Event.class)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEvent(@PathParam("eventId") String eventId) throws Exception {
        Event event = getDatabase().getEvent(eventId);

        if (eventId.equals("db")) {
            throw new Exception("Database error");
        }

        if (event == null) {
            throw new UserException("Event not found", "Event was not found!", "http://localhost:8080/errors/user-not-found");
        }

        return event;
    }

    @Path("/{eventId}")
    @DELETE
    @ApiOperation(value = "Remove event", notes = "Removes event", response = Event.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeEvent(@PathParam("eventId") String eventId) throws Exception {
        Event event = getDatabase().removeEvent(eventId);

        if (eventId.equals("db")) {
            throw new Exception("Database error");
        }

        if (event == null) {
            throw new UserException("Event not found", "Event was not found!", "http://localhost:8080/errors/user-not-found");
        }

        return Response.noContent().build();
    }

    @POST
    @ApiOperation(value = "Create event", notes = "Create event", response = Event.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent(Event event) {
        Event dbEvent = new Event(
                "",
                event.getEventName(),
                event.getEventDate(),
                event.getEventDesc()
        );

        Event createdEvent = getDatabase().createEvent(dbEvent);

        return Response.created(URI.create(uriInfo.getPath() + "/" + createdEvent.getId())).entity(createdEvent).build();
    }


    @Path("/{eventId}")
    @PUT
    @ApiOperation(value = "Update event", notes = "Create event", response = Event.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEvent(@PathParam("eventId") String eventId, Event event) {

        Event dbEvent = new Event(
                "",
                event.getEventName(),
                event.getEventDate(),
                event.getEventDesc()
        );

        Event updatedEvent = getDatabase().updateEvent(eventId, dbEvent);

        return Response.ok().entity(updatedEvent).build();
    }
}
