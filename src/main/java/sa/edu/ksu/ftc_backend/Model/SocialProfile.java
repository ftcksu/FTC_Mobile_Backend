package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class SocialProfile {

    public SocialProfile() {
    }

    public SocialProfile(@NotEmpty @Size(max = 40) String type, @NotEmpty @Size(max = 80) String value, User user) {
        this.type = type;
        this.value = value;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty
    @Size(max = 40)
    private String type;

    @NotEmpty
    @Size(max = 80)
    private String value;

    @ManyToOne
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
