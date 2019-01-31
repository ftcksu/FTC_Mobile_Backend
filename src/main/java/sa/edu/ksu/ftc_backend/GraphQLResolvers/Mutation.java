package sa.edu.ksu.ftc_backend.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import sa.edu.ksu.ftc_backend.Model.SocialProfile;
import sa.edu.ksu.ftc_backend.Model.User;
import sa.edu.ksu.ftc_backend.Repository.SocialProfileRepository;
import sa.edu.ksu.ftc_backend.Repository.UserRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {


    private UserRepository userRepository;
    private SocialProfileRepository socialProfileRepository;

    public Mutation(UserRepository userRepository,SocialProfileRepository socialProfileRepository){
        this.userRepository = userRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    public User newUser(String firstName,String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return userRepository.save(user);
    }

    public SocialProfile newSocialProfile(String type,String userId,String value) throws Exception{
        SocialProfile newSocialProfile = new SocialProfile();
        newSocialProfile.setType(type);
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new Exception("user can not be null");
        }
        newSocialProfile.setUser(user.get());
        newSocialProfile.setValue(value);
        socialProfileRepository.save(newSocialProfile);

        return socialProfileRepository.save(newSocialProfile);
    }

    public SocialProfile updateSocialProfileValue(String value,String id) throws Exception{
        Optional<SocialProfile> socialProfile = socialProfileRepository.findById(id);
        if(!socialProfile.isPresent()){
            throw new Exception("there is not a socialProfile with id :" +id);
        }
        socialProfile.get().setValue(value);
        return socialProfileRepository.save(socialProfile.get());
    }


}
