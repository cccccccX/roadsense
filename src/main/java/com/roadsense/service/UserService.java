package com.roadsense.service;

import com.roadsense.mapper.UserMapper;
import com.roadsense.pojo.User;
import com.roadsense.utils.Result;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 20:56
 */
public interface UserService {
    Result login(User user);

    Result checkUserName(String username);

    Result regist(User user);
}