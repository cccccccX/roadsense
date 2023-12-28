package com.roadsense.service.impl;

import com.roadsense.common.constant.MessageContant;
import com.roadsense.common.exception.AccountRepeatException;
import com.roadsense.entity.dto.UserLoginDTO;
import com.roadsense.common.exception.AccountNotFoundException;
import com.roadsense.common.exception.LoginFailedException;
import com.roadsense.entity.dto.UserRegisterDTO;
import com.roadsense.mapper.UserMapper;
import com.roadsense.entity.pojo.User;
import com.roadsense.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


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
     * 用户登录
     * @param userLoginDTO
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userMapper.getByUsername(userLoginDTO.getUsername());

        //用户不存在
        if (user == null){
            throw new AccountNotFoundException(MessageContant.ACCOUNT_NOT_FOUND);
        }

        String password = DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes());
        if (password.equals(user.getUserPwd())){
            return user;
        }

        throw new LoginFailedException(MessageContant.PASSWORD_OR_USERNAME_ERROR);

    }


    /**
     * 用户注册
     * @param registerDTO
     */
    @Override
    public void register(UserRegisterDTO registerDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        User temp = userMapper.getByUsername(user.getUserName());
        if (temp != null){
            throw new AccountRepeatException(MessageContant.USERNAME_REPEAT);
        }
        String password = user.getUserPwd();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setUserPwd(password);
        userMapper.insert(user);
    }


    //    /**
//     * 登录操作，根据用户名查询
//     * @param user
//     * @return
//     */
//    @Override
//    public Result login(User user) {
//
//        User loginUser = userMapper.selectByUserName(user.getUserName());
//        if (loginUser == null) {
//            return Result.build(null, CodeEnum.USERNAME_ERROR);
//        }
//        if (user.getUserPwd().equals(loginUser.getUserPwd())) {
//            return Result.ok(loginUser);
//        }
//        return Result.build(null, CodeEnum.PASSWORD_ERROR);
//    }
//
//
//    /**
//     * 检查用户名是否存在
//     * @param username
//     * @return
//     */
//    @Override
//    public Result checkUserName(String username) {
//        User user = userMapper.selectByUserName(username);
//        if (user == null) {
//            return Result.ok(null);
//        }
//        return Result.build(null, CodeEnum.USERNAME_USED);
//    }
//
//
//    /**
//     * 注册，添加用户
//     * @param user
//     * @return
//     */
//    @Override
//    public Result regist(User user) {
//        User existUser = userMapper.selectByUserName(user.getUserName());
//        if (existUser != null) {
//            return Result.build(null, CodeEnum.USERNAME_USED);
//        }
//
//        userMapper.insert(user);
//
//        return Result.ok(null);
//    }
//
//
//    /**
//     * 修改密码
//     * @param user
//     * @return
//     */
//    @Override
//    public boolean modifyPassword(User user) {
//        int i = userMapper.updatePassword(user);
//        return i == 1;
//    }



}
