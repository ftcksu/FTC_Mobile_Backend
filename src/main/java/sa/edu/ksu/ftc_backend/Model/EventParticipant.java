package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Event event;
    private ParticipantType type;

    @OneToMany(mappedBy = "participant")
    private List<Points> points;


    public EventParticipant() {
    }

    public EventParticipant(Account account, Event event, ParticipantType type) {
        this.account = account;
        this.event = event;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
