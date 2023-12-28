package com.roadsense.service;

import com.roadsense.entity.dto.UserLoginDTO;
import com.roadsense.entity.dto.UserRegisterDTO;
import com.roadsense.entity.pojo.User;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 20:56
 */

public interface UserService {

    /**
     * 用户登录
     * @param userLoginDTO
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     * @param registerDTO
     */
    void register(UserRegisterDTO registerDTO);

//    Result login(User user);
//
//    Result checkUserName(String username);
//
//    Result regist(User user);
//
//    @Transactional
//    boolean modifyPassword(User user);

}