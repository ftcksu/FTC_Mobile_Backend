package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String whatsappLink;
    private List<>
    private int organizersNumLimit;
    private int attendeesNumLimit;
    private Date date;
    private EventStatus status;

    public Event() {
    }

    public Event(String name, String whatsappLink, User leader, Set<User> organizers, Set<User> attendees, int organizersNumLimit, int attendeesNumLimit, Date date, EventStatus status) {
        this.name = name;
        this.whatsappLink = whatsappLink;
        this.leader = leader;
        this.organizers = organizers;
        this.attendees = attendees;
        this.organizersNumLimit = organizersNumLimit;
        this.attendeesNumLimit = attendeesNumLimit;
        this.date = date;
        this.status = status;
    }

    public String getId() {
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

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public Set<User> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Set<User> organizers) {
        this.organizers = organizers;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
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
