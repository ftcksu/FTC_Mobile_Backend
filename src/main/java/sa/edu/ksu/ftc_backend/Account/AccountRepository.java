package sa.edu.ksu.ftc_backend.Account;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Account.Account;

public interface AccountRepository extends CrudRepository<Account,Integer> {
}
