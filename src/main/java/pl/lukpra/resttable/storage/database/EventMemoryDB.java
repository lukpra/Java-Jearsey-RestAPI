package pl.lukpra.resttable.storage.database;

import pl.lukpra.resttable.storage.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventMemoryDB implements EventDatabase {
    private static Map<String, Event> events = new HashMap<String, Event>() {{
        put("0", new Event("0", "Bardzo wazny meeting w kantynie", "Kazdego dnia", "Obiad integracyjny"));
        put("1", new Event("1", "Prezentacja dokumentacji u klienta", "2016-04-24", "Zabrac projektor"));
        put("2", new Event("2", "Rozmowa kwalifikacyjna", "Juz niedlugo", "Dobrze rokujacy deweloper"));
        put("3", new Event("3", "Spotkanie z klientem 2", "2016-04-23", "jak w nazwie."));
    }};

    private Integer iter=4;

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
