package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;

import java.util.List;

public class AccountResolver implements GraphQLResolver<Account> {

    private SocialProfileRepository socialProfileRepository;

    public AccountResolver(SocialProfileRepository socialProfileRepository){
        this.socialProfileRepository = socialProfileRepository;
    }

    public List<SocialProfile> getSocialProfile(Account account){
        return socialProfileRepository.findAllByAccount(account);
    }

}
