package com.roadsense.mapper;

import com.roadsense.pojo.Feedback;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_feedback】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Feedback
*/
public interface FeedbackMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

}
