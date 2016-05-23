package pl.lukpra.resttable.storage.database;

import pl.lukpra.resttable.storage.model.Event;

import java.util.Collection;

public interface EventDatabase {
    Event getEvent(String id);

    Event updateEvent(String id, Event event);

    Event removeEvent(String id);

    Event createEvent(Event event);

    Collection<Event> getEvents();
}
