package sa.edu.ksu.ftc_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.Mutation;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.Query;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.AccountResolver;
import sa.edu.ksu.ftc_backend.Model.Account;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.AccountRepository;

import java.util.Optional;

@SpringBootApplication
public class FtcBackendApplication {

    @Bean
    public AccountResolver SocialProfileResolver(SocialProfileRepository socialProfileRepository){
        return new AccountResolver(socialProfileRepository);
    }

    @Bean
    public Query query(AccountRepository accountRepository, SocialProfileRepository socialProfileRepository){
        return new Query(accountRepository,socialProfileRepository);
    }

    @Bean
    public Mutation mutation(AccountRepository accountRepository, SocialProfileRepository socialProfileRepository){
        return new Mutation(accountRepository,socialProfileRepository);
    }


    public static void main(String[] args) {

        SpringApplication.run(FtcBackendApplication.class, args);
    }


}

