package com.roadsense.dto;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * author  Edith
 * created  2023/12/27 20:00
 */
@Data
public class FeedBackPageQueryDTO {
    private Long userId;
    private String roadName;
    private String desInfo;

    private Integer pageNum;
    private Integer pageSize;

}
