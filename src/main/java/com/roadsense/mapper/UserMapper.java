package com.roadsense.mapper;

import com.roadsense.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String username);

    int updatePassword(User user);

}
