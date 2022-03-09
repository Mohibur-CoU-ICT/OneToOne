package com.mohibur.OneToOne.Service;

import com.mohibur.OneToOne.Entity.User;
import com.mohibur.OneToOne.Repository.UserProfileRepository;
import com.mohibur.OneToOne.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> createUsers(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    @Override
    public User getUser(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
//            BeanUtils.copyProperties(userOptional.get(), user);
        } else {
            throw new RuntimeException("User not found for id = " + id);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
