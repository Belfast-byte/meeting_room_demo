package com.software.service;


import com.software.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUserById(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    List<User> allStudent();
}
