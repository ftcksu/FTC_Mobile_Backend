package sa.edu.ksu.ftc_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.Mutation;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.Query;
import sa.edu.ksu.ftc_backend.GraphQLResolvers.UserResolver;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.UserRepository;

@SpringBootApplication
public class FtcBackendApplication {

    @Bean
    public UserResolver SocialProfileResolver(SocialProfileRepository socialProfileRepository){
        return new UserResolver(socialProfileRepository);
    }

    @Bean
    public Query query(UserRepository userRepository,SocialProfileRepository socialProfileRepository){
        return new Query(userRepository,socialProfileRepository);
    }

    @Bean
    public Mutation mutation(UserRepository userRepository,SocialProfileRepository socialProfileRepository){
        return new Mutation(userRepository,socialProfileRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(FtcBackendApplication.class, args);
    }

}

