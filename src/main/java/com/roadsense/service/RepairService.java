package com.roadsense.service;

import com.roadsense.common.result.PageResult;
import com.roadsense.dto.RepairPageDTO;

/**
 * author  Edith
 * created  2023/12/27 20:54
 */
public interface RepairService {

    /**
     * 维护记录分页查询
     * @param repairPageDTO
     * @return
     */
    PageResult pageQuery(RepairPageDTO repairPageDTO);
}
