package com.mohibur.OneToOne.Service;

import com.mohibur.OneToOne.Entity.User;
import com.mohibur.OneToOne.Entity.UserProfile;
import com.mohibur.OneToOne.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfile(long id) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
        UserProfile userProfile;
        if(userProfileOptional.isPresent()) {
            userProfile = userProfileOptional.get();
        } else {
            throw new RuntimeException("UserProfile not found for id = " + id);
        }
        return userProfile;
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return (List<UserProfile>) userProfileRepository.findAll();
    }

    @Override
    public void deleteUserProfile(long id) {
        userProfileRepository.deleteById(id);
    }
}
