package sa.edu.ksu.ftc_backend.Model;

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

    @OneToMany(mappedBy = "event")
    private List<EventParticipant> participants;
    private int organizersNumLimit;
    private int attendeesNumLimit;
    private Date date;
    private EventStatus status;

    public Event() {
    }

    public Event(String name, String whatsappLink, int organizersNumLimit, int attendeesNumLimit, Date date, EventStatus status) {
        this.name = name;
        this.whatsappLink = whatsappLink;
        this.organizersNumLimit = organizersNumLimit;
        this.attendeesNumLimit = attendeesNumLimit;
        this.date = date;
        this.status = status;
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
}

enum EventStatus{
    Open,Closed
}
