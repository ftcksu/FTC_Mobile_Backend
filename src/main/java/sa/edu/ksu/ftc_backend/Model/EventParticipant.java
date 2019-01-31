package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private User user;
    private Event event;
    private ParticipantType type;


    public EventParticipant() {
    }

    public EventParticipant(User user, Event event, ParticipantType type) {
        this.user = user;
        this.event = event;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipantType getType() {
        return type;
    }

    public void setType(ParticipantType type) {
        this.type = type;
    }
}
enum ParticipantType{
    Leader,Attendee,Organizer
}
