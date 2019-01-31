package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Model.User;

import java.util.List;

public interface SocialProfileRepository extends CrudRepository<SocialProfile,String> {

    List<SocialProfile> findAllByUser(User user);

}
