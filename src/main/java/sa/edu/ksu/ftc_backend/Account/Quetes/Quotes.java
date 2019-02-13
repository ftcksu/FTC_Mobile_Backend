package sa.edu.ksu.ftc_backend.Account.Quetes;

import sa.edu.ksu.ftc_backend.Account.Account;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String value;
    @Valid
    @ManyToOne
    private Account account;

    public Quotes() {
    }

    public Quotes(@NotEmpty String value, @Valid Account account) {
        this.value = value;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAccount(@Valid Account account) {
        this.account = account;
    }
}
