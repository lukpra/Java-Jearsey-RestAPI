package pl.lukpra.resttable.storage.resources;

import com.wordnik.swagger.annotations.Api;
import pl.lukpra.resttable.storage.database.EventMemoryDB;
import pl.lukpra.resttable.storage.database.EventDatabase;

import javax.ws.rs.Path;

@Path("/events")
@Api(value = "/events", description = "Operations about events using static java array map")
public class MemoryEventsResource extends AbstractEventResource {
    private static final EventDatabase database = new EventMemoryDB();

    @Override
    protected EventDatabase getDatabase(){
        return database;
    }
}
