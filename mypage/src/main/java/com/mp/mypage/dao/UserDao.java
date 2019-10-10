package com.mp.mypage.dao;

import com.mp.mypage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id = #{id}")
    public User findById(int id);

    @Select("select * from user where username = #{username}")
    public User findByUsername(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(String username,String password);

    @Update("update user set" +
            "id = #{id}," +
            "username = #{username}," +
            "password = #{password}" +
            "where id = #{id}")
    public void update(User user);

    @Insert("insert into user values (username = #{username}, password = #{password})")
    @Options(keyProperty = "id" , useGeneratedKeys = true)
    public void insert(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(int id);


}
