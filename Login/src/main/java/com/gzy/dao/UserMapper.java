package com.gzy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzy.damain.User;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Insert("INSERT INTO t_user (USERNAME,PASSWORD,EMAIL,GENDER) values(#{username},#{password},#{email},#{gender})")
    int addUser(User user);

    @Select("select COUNT(*) from t_user where USERNAME=#{username} and PASSWORD=#{password}")
    int  findUserByNameAndPassWord(@Param("username") String username ,@Param("password") String password);

    @Select("select COUNT(*) from t_user where USERNAME=#{username}")
    int findUserByName(String username);


}