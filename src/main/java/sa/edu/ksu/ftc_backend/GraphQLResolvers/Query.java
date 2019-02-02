package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;

public class Query implements GraphQLQueryResolver {

    private AccountRepository accountRepository;
    private SocialProfileRepository socialProfileRepository;

    public Query(AccountRepository accountRepository, SocialProfileRepository socialProfileRepository){
        this.accountRepository = accountRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    public Iterable<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public Iterable<SocialProfile> findAllSocialProfiles(){
        return socialProfileRepository.findAll();
    }


}
