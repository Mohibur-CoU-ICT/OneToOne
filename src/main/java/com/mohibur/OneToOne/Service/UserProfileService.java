package com.mohibur.OneToOne.Service;

import com.mohibur.OneToOne.Entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile getUserProfile(long id);
    List<UserProfile> getAllUserProfiles();
    void deleteUserProfile(long id);
}
