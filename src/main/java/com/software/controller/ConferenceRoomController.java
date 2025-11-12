package com.software.controller;


import com.software.Entity.User;
import com.software.common.Result;
import com.software.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.builder.ResultMapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/meetingroom")
@Slf4j
@Component
public class ConferenceRoomController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Result<List> allStudent()
    {
        log.info("获取所有学生信息");
        List<User> userList = userService.allStudent();
        return Result.success(userList);
    }




    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable Long id) {

        User user = userService.getUserById(id);
        log.info("获取User信息 {}", user.getUsername());
        return Result.success(user);
    }
    @PostMapping("/user/add")
    public Result addUser(@RequestBody User user){
        log.info("添加User信息 {}",user.getUsername());
         userService.addUser(user);
        return Result.success("成功添加用户!");

    }
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return Result.success("成功删除用户!");
    }
    @PostMapping("/user/update")
    public Result update(@RequestBody User user){
       userService.updateUser(user);
       return Result.success("成功更新用户信息!");

    }
}


