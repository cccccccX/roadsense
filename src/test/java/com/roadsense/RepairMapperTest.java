package com.roadsense;

import com.roadsense.mapper.RepairMapper;
import com.roadsense.entity.pojo.Repair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 22:47
 */


//@SpringBootTest
public class RepairMapperTest {

    @Autowired
    private RepairMapper repairMapper;


    @Test
    public void testSelectAll(){
        List<Repair> repairs = repairMapper.selectList(null);
        System.out.println(repairs);
    }

}
