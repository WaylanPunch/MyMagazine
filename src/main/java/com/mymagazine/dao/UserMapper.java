package com.mymagazine.dao;

import com.mymagazine.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    long count();

    int checkUserIfExists(@Param("username") String username);

    //int deleteByExample(UserVoExample example);

    int deleteByUid(@Param("uid") Integer uid);

    int insertUser(@Param("user") User user);

    //int insertSelective(User record);

    //List<User> selectByExample(User user);

    List<User> selectAllUsers();

    User selectUserByUid(@Param("uid") Integer uid);

    User selectUserByUserAndPassword(@Param("username") String username, @Param("password") String password);

    //int updateByExampleSelective(@Param("record") User record, @Param("example") UserVoExample example);

    int updateUserByUid(@Param("user") User user);

    //int updateByPrimaryKeySelective(User record);

    //int updateByPrimaryKey(User record);

}
