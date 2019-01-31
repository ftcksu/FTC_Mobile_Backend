package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.User;

public interface UserRepository extends CrudRepository<User,String> {
}
