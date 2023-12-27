package com.roadsense.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.roadsense.common.result.PageResult;
import com.roadsense.entity.dto.RepairPageDTO;
import com.roadsense.mapper.RepairMapper;
import com.roadsense.service.RepairService;
import com.roadsense.entity.vo.RepairPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author  Edith
 * created  2023/12/27 20:54
 */
@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    /**
     * 维护记录分页查询
     * @param repairPageDTO
     * @return
     */
    @Override
    public PageResult pageQuery(RepairPageDTO repairPageDTO) {
        PageHelper.startPage(repairPageDTO.getPageNum(), repairPageDTO.getPageSize());
        Page<RepairPageVO> page = repairMapper.pageQuery(repairPageDTO);

        PageResult pageResult = new PageResult();
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(page.getResult());
        return pageResult;
    }
}
