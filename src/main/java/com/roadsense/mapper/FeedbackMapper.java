package com.roadsense.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.roadsense.entity.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_feedback】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Feedback
*/
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {
    Integer countByStatus(Integer status);




    /**
     * 分页查询带有修复状态
     * @param feedback
     * @return
     */
    Page<Feedback> list(Feedback feedback);

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Feedback record);
//
//    int insertSelective(Feedback record);
//
//    Feedback selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Feedback record);
//
//    int updateByPrimaryKey(Feedback record);

}
