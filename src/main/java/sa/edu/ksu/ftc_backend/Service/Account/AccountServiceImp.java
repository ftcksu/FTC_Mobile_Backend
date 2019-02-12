package sa.edu.ksu.ftc_backend.Service.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService{

    AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account save(@Valid Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(@NotNull Integer id) {
       return accountRepository.findById(id);
    }

    @Override
    public Account update(Account account) {
        Optional<Account> oldAccount = accountRepository.findById(account.getId());

        if (oldAccount.isPresent()) {
            if (account.getFirstName() != null)
                oldAccount.get().setFirstName(account.getFirstName());
            if (account.getLastName() != null)
                oldAccount.get().setLastName(account.getLastName());
            if (account.getEmail() != null)
                oldAccount.get().setEmail(account.getEmail());
            if (account.getPassword() != null) //TODO ENCRYPT
                oldAccount.get().setPassword(account.getPassword());
            if (account.getDeviceId() != null)
                oldAccount.get().setDeviceId(account.getDeviceId());
            if (account.getBio() != null)
                oldAccount.get().setBio(account.getBio());
        } else {
            throw new IllegalArgumentException();
        }

        return accountRepository.save(oldAccount.get());
    }

    @Override
    public void delete(@NotNull Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }
}
