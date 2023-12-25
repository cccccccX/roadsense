package com.roadsense.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadsense.pojo.Pit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_pit】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Pit
*/
@Mapper
public interface PitMapper extends BaseMapper<Pit> {

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Pit record);
//
//    int insertSelective(Pit record);
//
//    Pit selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Pit record);
//
//    int updateByPrimaryKey(Pit record);

    public int insert(Pit pit);

    /**
     * 根据道路id和时间统计坑洼数量
     * SELECT COUNT(pit_id) FROM t_pitinfo WHERE road_id = 3 AND TIME >= "2023-12-01 00:00:00" AND TIME <= "2023-12-31 23:59:59"
     * @param roadId
     * @param begin
     * @param end
     * @return
     */
    Integer countByRoadIdAndTime(@Param("id") Long roadId, @Param("beginTime") LocalDateTime begin, @Param("endTime") LocalDateTime end);



    /**
     * 根据始末时间和月份求健康指数
     * @return
     */
    BigDecimal calcHealthyByMonthAndTime(@Param("id") Long roadId, @Param("beginTime") LocalDateTime beginTime, @Param("endTime") LocalDateTime endTime);

    /**
     * 根据道路id和始末时间得到坑洼id
     * @param roadId
     * @return
     */
    List<Integer> getPitsByRoadId(@Param("id") Long roadId);

//    public List<Pit> selectAll();

}
