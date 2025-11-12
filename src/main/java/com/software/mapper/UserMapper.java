package com.software.mapper;


import com.software.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * from users where user_id = #{id}")
    User getUserById(Long id);
    @Insert("INSERT INTO users (user_id, username, full_name, email, phone) VALUES " +
            "(#{userId}, #{username}, #{fullName}, #{email}, #{phone})")
    void insertUser(User user);
    @Update("UPDATE users SET username = #{username}, full_name = #{fullName}, email = #{email}, phone = #{phone} WHERE user_id = #{userId}")
    void updateUser(User user);

    @Delete("delete  from users where user_id = #{id}")
    void delete(Long id);
    @Select("SELECT * from users")
    List<User> selectAllStudent();
}
