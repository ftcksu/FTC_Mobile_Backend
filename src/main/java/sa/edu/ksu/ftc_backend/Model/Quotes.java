package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotEmpty
    private String value;
    @Valid
    @ManyToOne
    private User user;

    public Quotes() {
    }

    public Quotes(@NotEmpty String value, @Valid User user) {
        this.value = value;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setUser(@Valid User user) {
        this.user = user;
    }
}
