package com.roadsense.controller;

import com.roadsense.pojo.User;
import com.roadsense.service.UserService;
import com.roadsense.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 20:34
 */
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;
//    UserMapper userMapper;

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable("id") Long id){
//        return userMapper.selectByPrimaryKey(id);
//    }
    /**
     * 登录需求
     * 地址: /user/login
     * 方式: post
     * @param{
     *     "userId":"xcc",
     *     "userPwd":"cc20021010"
     *     “isManager":"true"
     * }
     * @return{
     *     "code": 200,
     *     "message": "success",
     *     "data": {
     *         "userId": 1,
     *         "userName": "xcc",
     *         "userPwd": "cc20021010",
     *         "nickname": "cherry",
     *         "userTel": "15057554044"
     *     }
     * }
     */
    @PostMapping("login")
    public Result login(@RequestBody User user){
        System.out.println("success");
        Result result = userService.login(user);
        System.out.println("result = " + result);
        return result;
    }
    @PostMapping("checkUserName")
    public Result checkUserName(String username){
        Result result = userService.checkUserName(username);
        return result;
    }


    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }
}
