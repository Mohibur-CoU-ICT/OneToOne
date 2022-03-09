package com.mohibur.OneToOne.Controller;

import com.mohibur.OneToOne.Entity.User;
import com.mohibur.OneToOne.Entity.UserProfile;
import com.mohibur.OneToOne.Service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(value = "/create")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(userProfile);
    }

    @GetMapping(value = "")
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping(value = "/{id}")
    public UserProfile getUserProfileId(@PathVariable("id") long id){
        return userProfileService.getUserProfile(id);
    }

    @PutMapping(value = "/update/{id}")
    public UserProfile updateUserProfile(@PathVariable(value = "id") long id, @RequestBody UserProfile userProfile) {
        UserProfile userProfile1 = userProfileService.getUserProfile(id);

        if(userProfile.getPhoneNumber() != null) userProfile1.setPhoneNumber(userProfile.getPhoneNumber());
        if(userProfile.getAddress() != null)     userProfile1.setAddress(userProfile.getAddress());
        if(userProfile.getGender() != null)      userProfile1.setGender(userProfile.getGender());
        if(userProfile.getDateOfBirth() != null) userProfile1.setDateOfBirth(userProfile.getDateOfBirth());

        return userProfileService.createUserProfile(userProfile1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserProfile(@PathVariable("id") long id) {
        userProfileService.deleteUserProfile(id);
    }
}
