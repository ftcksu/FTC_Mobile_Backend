package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;

import java.util.List;

public interface SocialProfileRepository extends CrudRepository<SocialProfile,Integer> {

    List<SocialProfile> findAllByAccount(Account account);

}
