package sa.edu.ksu.ftc_backend.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class User {

    private String id;

    private String firstName;

    private String lastName;

    private String studentId;

    private List<Role> roles;

    private String email;

    private String password;

    private SocialProfile socialProfile;

    private String deviceId;

    private String bio;
}
