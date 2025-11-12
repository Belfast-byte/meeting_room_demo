package com.software.service.Impl;

import com.software.Entity.User;
import com.software.mapper.UserMapper;
import com.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        User user = new User();

        user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

    @Override
    public void updateUser(User user) {

        if (user == null) {
            return;
        }
        userMapper.updateUser(user);
    }

    @Override
    public List<User> allStudent() {
        List<User>  userList = userMapper.selectAllStudent();
        return userList;
    }


}
