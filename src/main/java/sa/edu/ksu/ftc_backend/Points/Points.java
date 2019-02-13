package sa.edu.ksu.ftc_backend.Points;

import sa.edu.ksu.ftc_backend.Event.Participant.EventParticipant;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Valid
    @ManyToOne
    private EventParticipant participant;
    private int value;

    private boolean isApprovedByAdmin;
    private boolean isApprovedByLeader;
    private String description;

    public Points() {
        this.isApprovedByAdmin =false;
        this.isApprovedByLeader=false;
    }

    public Points(@Valid EventParticipant participant, int value, List<EventParticipant> event, boolean isApprovedByAdmin, boolean isApprovedByLeader, String description) {
        this.participant = participant;
        this.value = value;
        this.isApprovedByAdmin = isApprovedByAdmin;
        this.isApprovedByLeader = isApprovedByLeader;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(EventParticipant participant) {
        this.participant = participant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isApprovedByAdmin() {
        return isApprovedByAdmin;
    }

    public void setApprovedByAdmin(boolean approvedByAdmin) {
        isApprovedByAdmin = approvedByAdmin;
    }

    public boolean isApprovedByLeader() {
        return isApprovedByLeader;
    }

    public void setApprovedByLeader(boolean approvedByLeader) {
        isApprovedByLeader = approvedByLeader;
    }

    public String getDescriptions() {
        return description;
    }

    public void setDescriptions(String description) {
        this.description = description;
    }
}
