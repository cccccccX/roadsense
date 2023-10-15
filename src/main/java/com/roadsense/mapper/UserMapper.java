package com.roadsense.mapper;

import com.roadsense.pojo.User;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-15 12:01:27
* @Entity com.roadsense.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
