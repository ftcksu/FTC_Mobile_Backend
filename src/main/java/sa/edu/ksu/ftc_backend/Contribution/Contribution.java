package sa.edu.ksu.ftc_backend.Contribution;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
