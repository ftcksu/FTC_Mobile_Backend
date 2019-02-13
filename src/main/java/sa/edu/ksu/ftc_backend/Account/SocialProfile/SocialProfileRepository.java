package sa.edu.ksu.ftc_backend.Account.SocialProfile;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Account.Account;
import sa.edu.ksu.ftc_backend.Account.SocialProfile.SocialProfile;

import java.util.List;

public interface SocialProfileRepository extends CrudRepository<SocialProfile,Integer> {

    List<SocialProfile> findAllByAccount(Account account);

}
