package pl.lukpra.resttable.storage.entity;


import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.Table;

@Entity
@Table(name = "events")
@NamedQueries({
        @NamedQuery(name = "events.findAll", query = "Select e FROM EventEntity e")
})
public class EventEntity {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String eventName;

    @Column(name = "dateOf")
    private String eventDate;

    @Column(name = "desc")
    private String eventDesc;

    private boolean active = false;

    // Pre/Post Load, Pre/Post Persist
    @PostLoad
    private void postLoad() {
        LOGGER.info("postLoad: {}", toString());
    }

    public EventEntity(String eventName, String eventDate, String eventDesc, boolean active) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDesc = eventDesc;
        this.active = active;
    }

    public Long getId(){
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public boolean isActive() {
        return active;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public void setActive(boolean active ) {
        this.active = active;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("eventName", eventName)
                .add("eventDate", eventDate)
                .add("eventDesc", eventDesc)
                .toString();
    }
}
