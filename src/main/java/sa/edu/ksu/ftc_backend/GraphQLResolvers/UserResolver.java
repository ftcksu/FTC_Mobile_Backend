package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Model.User;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;

import java.util.List;

public class UserResolver implements GraphQLResolver<User> {

    private SocialProfileRepository socialProfileRepository;

    public UserResolver(SocialProfileRepository socialProfileRepository){
        this.socialProfileRepository = socialProfileRepository;
    }

    public List<SocialProfile> getSocialProfile(User user){
        return socialProfileRepository.findAllByUser(user);
    }

}
