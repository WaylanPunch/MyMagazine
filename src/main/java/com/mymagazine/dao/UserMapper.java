package com.mymagazine.dao;

import com.mymagazine.bean.User;
import com.mymagazine.bean.UserCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    long countByCondition(UserCondition condition);

    int deleteByCondition(UserCondition condition);

    int deleteByPrimaryKey(Integer uid);

    int insert(User user);

    int insertSelective(User user);

    List<User> selectByCondition(UserCondition condition);

    User selectByPrimaryKey(Integer uid);

    int updateByConditionSelective(@Param("user") User user, @Param("condition") UserCondition condition);

    int updateByCondition(@Param("user") User user, @Param("condition") UserCondition condition);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

}
