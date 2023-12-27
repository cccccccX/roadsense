package com.roadsense.entity.dto;

import lombok.Data;

/**
 * author  Edith
 * created  2023/12/27 20:52
 */
@Data
public class RepairPageDTO {
    private Long pitId;
    private Long handlerId;
    private String roadName;
    private Integer repairStatus;
    private Integer pageNum;
    private Integer pageSize;
}
