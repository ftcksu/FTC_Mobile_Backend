package sa.edu.ksu.ftc_backend.Account.SocialProfile;

import sa.edu.ksu.ftc_backend.Account.Account;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class SocialProfile {

    public SocialProfile() {
    }

    public SocialProfile(@NotEmpty @Size(max = 40) String type, @NotEmpty @Size(max = 80) String value, Account account) {
        this.type = type;
        this.value = value;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(max = 40)
    private String type;

    @NotEmpty
    @Size(max = 80)
    private String value;

    @ManyToOne
    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
