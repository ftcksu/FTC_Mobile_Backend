package sa.edu.ksu.ftc_backend.Event;

import sa.edu.ksu.ftc_backend.Event.Participant.EventParticipant;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String whatsappLink;
    @Enumerated(EnumType.STRING)
    private EventType type;

    @OneToMany(mappedBy = "event")
    private List<EventParticipant> participants;
    private int organizersNumLimit;
    private int attendeesNumLimit;
    private Date date;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    public Event() {
    }

    public Event(String name, String whatsappLink, int organizersNumLimit, int attendeesNumLimit, Date date, String description, EventStatus status,
                 EventType type, List<EventParticipant> participants) {
        this.name = name;
        this.whatsappLink = whatsappLink;
        this.organizersNumLimit = organizersNumLimit;
        this.attendeesNumLimit = attendeesNumLimit;
        this.date = date;
        this.description = description;
        this.status = status;
        this.type = type;
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhatsappLink() {
        return whatsappLink;
    }

    public void setWhatsappLink(String whatsappLink) {
        this.whatsappLink = whatsappLink;
    }

    public int getOrganizersNumLimit() {
        return organizersNumLimit;
    }

    public void setOrganizersNumLimit(int organizersNumLimit) {
        this.organizersNumLimit = organizersNumLimit;
    }

    public int getAttendeesNumLimit() {
        return attendeesNumLimit;
    }

    public void setAttendeesNumLimit(int attendeesNumLimit) {
        this.attendeesNumLimit = attendeesNumLimit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }


    public List<EventParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<EventParticipant> participants) {
        this.participants = participants;
    }

}


