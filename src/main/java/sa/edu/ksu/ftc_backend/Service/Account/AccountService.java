package sa.edu.ksu.ftc_backend.Service.Account;

import sa.edu.ksu.ftc_backend.Model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account save(Account account);
    public Optional<Account> findById(Integer id);
    public Account update(Account account);
    public void delete(Integer id);
    public Iterable<Account> findAll();
}
