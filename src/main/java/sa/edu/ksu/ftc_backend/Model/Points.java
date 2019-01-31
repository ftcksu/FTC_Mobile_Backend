package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Valid
    @ManyToOne
    private User user;
    private int value;

    private Event event;

    private boolean isApprovedByadmin;
    private boolean isApprovedByLeader;
    private String decription;

    public Points() {
        this.isApprovedByadmin=false;
        this.isApprovedByLeader=false;
    }

    public Points(@Valid User user, int value, Event event, boolean isApprovedByadmin, boolean isApprovedByLeader, String decription) {
        this.user = user;
        this.value = value;
        this.event = event;
        this.isApprovedByadmin = isApprovedByadmin;
        this.isApprovedByLeader = isApprovedByLeader;
        this.decription = decription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isApprovedByadmin() {
        return isApprovedByadmin;
    }

    public void setApprovedByadmin(boolean approvedByadmin) {
        isApprovedByadmin = approvedByadmin;
    }

    public boolean isApprovedByLeader() {
        return isApprovedByLeader;
    }

    public void setApprovedByLeader(boolean approvedByLeader) {
        isApprovedByLeader = approvedByLeader;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
