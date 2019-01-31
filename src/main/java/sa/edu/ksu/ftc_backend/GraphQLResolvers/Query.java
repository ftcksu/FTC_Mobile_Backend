package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Model.User;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.UserRepository;

public class Query implements GraphQLQueryResolver {

    private UserRepository userRepository;
    private SocialProfileRepository socialProfileRepository;

    public Query(UserRepository userRepository,SocialProfileRepository socialProfileRepository){
        this.userRepository = userRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Iterable<SocialProfile> findAllSocialProfiles(){
        return socialProfileRepository.findAll();
    }


}
