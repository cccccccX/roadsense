package com.roadsense.entity.pojo;

//import java.io.Serializable;
//import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @TableName t_user
 */
@Data
public class User {
    @TableId
    private Long userId;

    private String userName;

    private String userPwd;

    private String userTel;

    private Integer isManager;

}