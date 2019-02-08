package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.dao.EmptyResultDataAccessException;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;

import java.lang.reflect.Field;
import java.util.Optional;


public class Mutation implements GraphQLMutationResolver {


    private AccountRepository accountRepository;
    private SocialProfileRepository socialProfileRepository;

    public Mutation(AccountRepository accountRepository, SocialProfileRepository socialProfileRepository) {
        this.accountRepository = accountRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    public Account createAccount(String firstName, String lastName, String studentId, String email, String password
            , String deviceId, String bio) {
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setStudentId(studentId);
        account.setEmail(email);
        account.setPassword(password);
        account.setDeviceId(deviceId);
        account.setBio(bio);

        return accountRepository.save(account);
    }

    public SocialProfile newSocialProfile(String type, Integer accountId, String value) throws Exception {
        SocialProfile newSocialProfile = new SocialProfile();
        newSocialProfile.setType(type);
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new Exception("account can not be null");
        }
        newSocialProfile.setAccount(account.get());
        newSocialProfile.setValue(value);
        socialProfileRepository.save(newSocialProfile);

        return socialProfileRepository.save(newSocialProfile);
    }

    public SocialProfile updateSocialProfileValue(String value, Integer id) throws Exception {
        Optional<SocialProfile> socialProfile = socialProfileRepository.findById(id);
        if (!socialProfile.isPresent()) {
            throw new Exception("there is not a socialProfile with id :" + id);
        }
        socialProfile.get().setValue(value);
        return socialProfileRepository.save(socialProfile.get());
    }

    public Account updateAccount(Account account) {
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

    public boolean deleteAccount(Integer id) {
        try {
            accountRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
