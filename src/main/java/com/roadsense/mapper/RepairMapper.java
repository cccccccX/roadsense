package com.roadsense.mapper;

import com.roadsense.pojo.Repair;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_repair】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Repair
*/
public interface RepairMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);

}
