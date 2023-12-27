package com.roadsense.entity.vo;

import lombok.Builder;
import lombok.Data;

/**
 * author  Edith
 * created  2023/12/27 22:23
 */
@Data
@Builder
public class UserLoginVO {
    private Long userId;
    private String username;
    private String token;

}
