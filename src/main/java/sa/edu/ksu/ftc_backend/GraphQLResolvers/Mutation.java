package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {


    private AccountRepository accountRepository;
    private SocialProfileRepository socialProfileRepository;

    public Mutation(AccountRepository accountRepository, SocialProfileRepository socialProfileRepository){
        this.accountRepository = accountRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    public Account newAccount(String firstName, String lastName,String studentId,String email,String password
            ,String deviceId, String bio){
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

    public SocialProfile newSocialProfile(String type,Integer accountId,String value) throws Exception{
        SocialProfile newSocialProfile = new SocialProfile();
        newSocialProfile.setType(type);
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()){
            throw new Exception("account can not be null");
        }
        newSocialProfile.setAccount(account.get());
        newSocialProfile.setValue(value);
        socialProfileRepository.save(newSocialProfile);

        return socialProfileRepository.save(newSocialProfile);
    }

    public SocialProfile updateSocialProfileValue(String value,Integer id) throws Exception{
        Optional<SocialProfile> socialProfile = socialProfileRepository.findById(id);
        if(!socialProfile.isPresent()){
            throw new Exception("there is not a socialProfile with id :" +id);
        }
        socialProfile.get().setValue(value);
        return socialProfileRepository.save(socialProfile.get());
    }


}
