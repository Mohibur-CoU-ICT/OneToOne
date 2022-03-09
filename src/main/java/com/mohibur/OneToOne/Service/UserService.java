package com.mohibur.OneToOne.Service;

import com.mohibur.OneToOne.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> createUsers(List<User> userList);
    User getUser(long id);
    List<User> getAllUsers();
    void deleteUser(long id);
}
