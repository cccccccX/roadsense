package com.roadsense.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadsense.pojo.Pit;
import org.apache.ibatis.annotations.Mapper;

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

//    public List<Pit> selectAll();

}
