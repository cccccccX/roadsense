package com.roadsense.service.impl;

import com.roadsense.common.constant.RepairedConstant;
import com.roadsense.common.constant.RoadConstant;
import com.roadsense.entity.dto.RoadHealthyDTO;
import com.roadsense.entity.dto.RoadPitCountDTO;
import com.roadsense.entity.dto.RoadRepairedDTO;
import com.roadsense.mapper.PitMapper;
import com.roadsense.mapper.RepairMapper;
import com.roadsense.mapper.RoadMapper;
import com.roadsense.entity.pojo.Road;
import com.roadsense.service.RoadService;
import com.roadsense.entity.vo.RoadHealthyVO;
import com.roadsense.entity.vo.RoadPitCountVO;
import com.roadsense.entity.vo.RoadRepairedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * author  Edith
 * created  2023/10/30 16:45
 */
@Service
@Slf4j
public class RoadServiceImpl implements RoadService {

    @Autowired
    private RoadMapper roadMapper;

    @Autowired
    private PitMapper pitMapper;

    @Autowired
    private RepairMapper repairMapper;

    /**
     * 根据id删除道路
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteById(Long id) {
        int i = roadMapper.deleteById(id);
        return i == 1;
    }

    /**
     * 新增一条道路
     * @param road
     * @return
     */
    @Override
    @Transactional
    public boolean insert(Road road) {
        int row = roadMapper.insert(road);
        return row == 1;
    }


    /**
     * 根据道路名字得到道路id
     * @param name
     * @return
     */
    @Override
    public Road getRoadId(String name) {
        Road road = roadMapper.selectByRoadName(name);
        return road;
    }

    /**
     * 各街道坑洼数量统计
     * @return
     */
    @Override
    public RoadPitCountVO pitCount() {
        log.info("各街道坑洼数量统计, 随机选择三个街道");
        //首先先随机查找获取到三条街道
        List<Road> roads = roadMapper.random(RoadConstant.RANDOM_ROAD_NUM);

        //获取近六个月的时间
        List<LocalDate> localDates = new ArrayList<>();
        LocalDate now = LocalDate.now();
        localDates.add(now);
        for (int i = 1; i < 6; i++){
            now = now.minusMonths(1);
            localDates.add(now);
        }

        List<String> date = new ArrayList<>();
        for (int i = 5; i >= 0; i--) date.add(localDates.get(i).getMonthValue() + "月");

        List<RoadPitCountDTO> list = new ArrayList<>();
        for (Road road : roads){
            List<Integer> pitCount = new ArrayList<>();
            RoadPitCountDTO roadPitCountDTO = new RoadPitCountDTO();
            roadPitCountDTO.setRoadName(road.getRoadName());
            for (int i = 5; i >= 0; i--){
                //遍历每个月 统计次数
//                date.add(localDates.get(i).getMonthValue() + "月");
                now = localDates.get(i);
                //获得这个月的第一天和最后一天
                LocalDateTime begin = LocalDateTime.of(LocalDate.of(now.getYear(), now.getMonthValue(), 1), LocalTime.MIN);
                LocalDateTime end = LocalDateTime.of(now.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
                //查询每条道路的该月的坑洼数量
                Integer cnt = pitMapper.countByRoadIdAndTime(road.getRoadId(), begin, end);
                if (cnt == null) cnt = 0;
                pitCount.add(cnt);

            }
            roadPitCountDTO.setPitCount(pitCount);
            list.add(roadPitCountDTO);
        }

        RoadPitCountVO roadPitCountVO = RoadPitCountVO.builder()
                .date(date)
                .list(list)
                .build();

        return roadPitCountVO;
    }


    @Override
    public RoadHealthyVO healthy() {
        //首先挑选三条街道
        List<Road> roads = roadMapper.random(3);

        //获取最近六个月
        LocalDate now = LocalDate.now();
        List<LocalDate> localDates = new ArrayList<>();
        localDates.add(now);
        List<String> date = new ArrayList<>();

        for (int i = 1; i < 6; i++){
            now = now.minusMonths(1);
            localDates.add(now);
        }
        for (int i = 5; i >= 0; i--){
            date.add(localDates.get(i).getMonthValue() + "月");
        }

        List<RoadHealthyDTO> list = new ArrayList<>();

        //查询
        for (Road road : roads){
            RoadHealthyDTO roadHealthyDTO = new RoadHealthyDTO();

            roadHealthyDTO.setRoadName(road.getRoadName());
            List<BigDecimal> healthy = new ArrayList<>();
            for (int i = 5; i >= 0; i--){
                now = localDates.get(i);

                //获取这个月的第一天
                LocalDateTime begin = LocalDateTime.of(LocalDate.of(now.getYear(), now.getMonthValue(), 1), LocalTime.MIN);
                //获取这个月的最后一天
                LocalDateTime end = LocalDateTime.of(now.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);

                BigDecimal h = pitMapper.calcHealthyByMonthAndTime(road.getRoadId(), begin, end);
                if (h == null) h = BigDecimal.valueOf(0);
                healthy.add(h);
            }

            roadHealthyDTO.setHealthyExp(healthy);
            list.add(roadHealthyDTO);
        }


        RoadHealthyVO roadHealthyVO = RoadHealthyVO.builder()
                .list(list)
                .date(date)
                .build();

        return roadHealthyVO;

    }

    /**
     * 各街道维护坑洼数量统计
     * @return RoadRepairedVO
     */
    @Override
    public RoadRepairedVO repairedPits() {
        //首先挑选三条街道
        List<Road> roads = roadMapper.random(3);

        //获取最近六个月
        LocalDate now = LocalDate.now();
        List<LocalDate> localDates = new ArrayList<>();
        localDates.add(now);
        List<String> date = new ArrayList<>();

        for (int i = 1; i < 6; i++){
            now = now.minusMonths(1);
            localDates.add(now);
        }
        for (int i = 5; i >= 0; i--){
            date.add(localDates.get(i).getMonthValue() + "月");
        }


        List<RoadRepairedDTO> list = new ArrayList<>();

        for (Road road : roads){
            RoadRepairedDTO roadRepairedDTO = new RoadRepairedDTO();

            roadRepairedDTO.setRoadName(road.getRoadName());
            List<Integer> repairedPits = new ArrayList<>();
            for (int i = 5; i >= 0; i--){
                now = localDates.get(i);

                //获取这个月的第一天
                LocalDateTime begin = LocalDateTime.of(LocalDate.of(now.getYear(), now.getMonthValue(), 1), LocalTime.MIN);
                //获取这个月的最后一天
                LocalDateTime end = LocalDateTime.of(now.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);

                List<Integer> pits = pitMapper.getPitsByRoadId(road.getRoadId());

                if (pits == null || pits.size() == 0){
                    repairedPits.add(0);
                    continue;
                }

                Integer cnt = repairMapper.countByPitsAndTime(pits, RepairedConstant.REPAIR_COMPLET, begin, end);

                if (cnt == null) cnt = 0;

                repairedPits.add(cnt);
            }
            roadRepairedDTO.setRepairCount(repairedPits);
            list.add(roadRepairedDTO);
        }

        RoadRepairedVO roadRepairedVO = RoadRepairedVO.builder()
                .date(date)
                .list(list)
                .build();
        return roadRepairedVO;
    }
}
