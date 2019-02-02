package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Account;

public interface AccountRepository extends CrudRepository<Account,Integer> {
}
