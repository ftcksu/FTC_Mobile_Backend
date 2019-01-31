package sa.edu.ksu.ftc_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Account")
public class User {

    public User() {

    }

    public User(String id, String firstName, String lastName, String studentId, String email, String password, List<SocialProfile> socialProfile, String deviceId, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
        this.password = password;
        this.socialProfile = socialProfile;
        this.deviceId = deviceId;
        this.bio = bio;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty
    @Size(max = 30)
    private String firstName;

    @NotEmpty
    @Size(max = 40)
    private String lastName;

    @NotEmpty
    private String studentId;

//    private List<Role> roles;

    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private List<SocialProfile> socialProfile;

    private String deviceId;

    private String bio;

    @OneToMany(mappedBy = "user")
    private List<Quotes> quotes;

    @OneToMany(mappedBy = "user")
    private List<Points> points;

    private List<EventParticipant>


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SocialProfile> getSocialProfile() {
        return socialProfile;
    }

    public void setSocialProfile(List<SocialProfile> socialProfile) {
        this.socialProfile = socialProfile;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", socialProfile=" + socialProfile +
                ", deviceId='" + deviceId + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }


}
