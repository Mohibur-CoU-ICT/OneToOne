package com.mohibur.OneToOne.Controller;

import com.mohibur.OneToOne.Entity.User;
import com.mohibur.OneToOne.Entity.UserProfile;
import com.mohibur.OneToOne.Service.UserProfileService;
import com.mohibur.OneToOne.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping(value = "/create/many")
    public List<User> createUsers(@RequestBody List<User> userList) {
        return userService.createUsers(userList);
    }

    @GetMapping(value = "")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser(@PathVariable(value = "id") long id, @RequestBody User user) {
        User updatedUser = userService.getUser(id);

        if(user.getName() != null)  updatedUser.setName(user.getName());
        if(user.getEmail() != null) updatedUser.setEmail(user.getEmail());
//        if(user.getUserProfile() != null) updatedUser.setUserProfile(user.getUserProfile());

        UserProfile userProfile1 = user.getUserProfile();
        if(userProfile1 != null) {
            if(userProfile1.getAddress() != null)     updatedUser.getUserProfile().setAddress(userProfile1.getAddress());
            if(userProfile1.getGender() != null)      updatedUser.getUserProfile().setGender(userProfile1.getGender());
            if(userProfile1.getPhoneNumber() != null) updatedUser.getUserProfile().setPhoneNumber(userProfile1.getPhoneNumber());
            if(userProfile1.getDateOfBirth() != null) updatedUser.getUserProfile().setDateOfBirth(userProfile1.getDateOfBirth());
        }

        return userService.createUser(updatedUser);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
    }
}
