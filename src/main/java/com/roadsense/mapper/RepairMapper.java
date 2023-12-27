package com.roadsense.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadsense.pojo.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_repair】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Repair
*/
@Mapper
public interface RepairMapper extends BaseMapper<Repair> {

    /**
     * 根据坑洼id统计修复完成的坑洼
     * @param pitIds
     * @return
     */
    Integer countByPitsAndTime(List<Integer> pitIds, @Param("status") Integer status, @Param("beginTime") LocalDateTime begin, @Param("endTime") LocalDateTime end);

    /**
     * 根据状态计数
     * @param status
     * @return
     */
    Integer countByStatus(Integer status);

    /**
     * 得到不重复的pit_id
     * @return
     */
    List<Integer> getDistinctPitIds();

    /**
     * 根据坑洼id查找修复记录
     * @param pitId
     * @return
     */
    Repair selectByPitId(Long id);

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Repair record);
//
//    int insertSelective(Repair record);
//
//    Repair selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Repair record);
//
//    int updateByPrimaryKey(Repair record);

}
