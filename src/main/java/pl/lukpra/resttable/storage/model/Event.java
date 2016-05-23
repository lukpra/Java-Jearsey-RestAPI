package pl.lukpra.resttable.storage.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Event")
public class Event {
    private String id;
    private String eventName;
    private String eventDate;
    private String eventDesc;

    public Event() {

    }

    public void setId(String id) {
        this.id = id;
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

    public Event(String id,String eventName, String eventDate, String eventDesc) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDesc = eventDesc;
    }

    @ApiModelProperty(value = "Event id", required = true)
    public String getId() {
        return id;
    }

    @ApiModelProperty(value = "Event name", required = true)
    public String getEventName() {
        return eventName;
    }

    @ApiModelProperty(value = "Date of event", required = true)
    public String getEventDate() {
        return eventDate;
    }

    @ApiModelProperty(value = "Event Description", required = true)
    public String getEventDesc() {
        return eventDesc;
    }

}
