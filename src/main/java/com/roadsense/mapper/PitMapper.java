package com.roadsense.mapper;

import com.roadsense.pojo.Pit;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_pit】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Pit
*/
public interface PitMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Pit record);

    int insertSelective(Pit record);

    Pit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pit record);

    int updateByPrimaryKey(Pit record);

}
