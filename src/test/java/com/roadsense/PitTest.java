package com.roadsense;

import com.roadsense.pojo.Pit;
import com.roadsense.service.PitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * author  Edith
 * created  2023/11/1 17:38
 */
@SpringBootTest
public class PitTest {
    @Autowired
    private PitService pitService;

    @Test
    public void testSelect(){
        Pit pit = new Pit();
////        pit.setPitId(1L);
//        pit.setRoadId(3L);
//        pit.setNotes("测试");

        List<Pit> pits = pitService.select(pit);
        for (Pit i : pits){
            System.out.println(i);
        }
    }

    @Test
    public void testDelete(){

        System.out.println(pitService.deleteById(1L));
    }

}
