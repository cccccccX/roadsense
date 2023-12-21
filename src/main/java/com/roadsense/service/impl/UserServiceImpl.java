package com.roadsense.service.impl;

import com.roadsense.mapper.UserMapper;
import com.roadsense.pojo.User;
import com.roadsense.service.UserService;
import com.roadsense.common.result.Result;
import com.roadsense.common.result.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 21:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 登录操作，根据用户名查询
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {

        User loginUser = userMapper.selectByUserName(user.getUserName());
        if (loginUser == null) {
            return Result.build(null, CodeEnum.USERNAME_ERROR);
        }
        if (user.getUserPwd().equals(loginUser.getUserPwd())) {
            return Result.ok(loginUser);
        }
        return Result.build(null, CodeEnum.PASSWORD_ERROR);
    }


    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    @Override
    public Result checkUserName(String username) {
        User user = userMapper.selectByUserName(username);
        if (user == null) {
            return Result.ok(null);
        }
        return Result.build(null, CodeEnum.USERNAME_USED);
    }


    /**
     * 注册，添加用户
     * @param user
     * @return
     */
    @Override
    public Result regist(User user) {
        User existUser = userMapper.selectByUserName(user.getUserName());
        if (existUser != null) {
            return Result.build(null, CodeEnum.USERNAME_USED);
        }

        userMapper.insert(user);

        return Result.ok(null);
    }


    /**
     * 修改密码
     * @param user
     * @return
     */
    @Override
    public boolean modifyPassword(User user) {
        int i = userMapper.updatePassword(user);
        return i == 1;
    }
}
