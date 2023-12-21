package com.roadsense.mapper;

import com.roadsense.pojo.Road;
import com.roadsense.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author c'c'c'c'c'c'x
* @description 针对表【t_road】的数据库操作Mapper
* @createDate 2023-10-19 15:17:15
* @Entity com.roadsense.pojo.Road
*/
@Mapper
public interface RoadMapper {

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Road record);
//
//    int insertSelective(Road record);
//
//    Road selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Road record);
//
//    int updateByPrimaryKey(Road record);

    public int deleteById(Long id);

    public int insert(Road road);

    public Road selectByRoadName(String name);

    List<Road> random(int cnt);
}
