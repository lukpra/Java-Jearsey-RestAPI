package pl.lukpra.resttable.storage.database;

import pl.lukpra.resttable.storage.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventMemoryDB implements EventDatabase {
    private static Map<String, Event> events = new HashMap<String, Event>() {{
        put("0", new Event("0", "Metting number One - Company Dinner", "Every Day", "Integration"));
        put("1", new Event("1", "Meeting number Two", "Date 1", "Some description 1"));
        put("2", new Event("2", "Meeting number Three", "Soon", "Some description 2"));
        put("3", new Event("3", "Meeting number Four", "2016-04-23", "Some description 3"));
    }};

    private Integer iter=4; // for hardcoded number of events

    private void incrementIter (){
        iter = iter + 1;
    }

    @Override
    public Event getEvent(String id){
        return events.get(id);
    }

    @Override
    public Event updateEvent(String id, Event event){
        Event existedEvent = events.get(id);
        if (existedEvent != null) {
            existedEvent.setEventName(event.getEventName());
            existedEvent.setEventDate(event.getEventDate());
            existedEvent.setEventDesc(event.getEventDesc());
            events.put(id, existedEvent);
            return existedEvent;
        }
        return null;
    }

    @Override
    public Event removeEvent(String id){
        Event existedEvent = events.get(id);
        if (existedEvent != null) {
            events.remove(id);
            return existedEvent;
        }
        return null;
    }

    @Override
    public Event createEvent(Event event){
        String id = Integer.toString(iter);
        incrementIter();
        Event value = new Event(id, event.getEventName(), event.getEventDate(), event.getEventDesc());
        events.put(id, value);
        return value;
    }

    @Override
    public Collection<Event> getEvents(){
        return events.values();
    }
}
