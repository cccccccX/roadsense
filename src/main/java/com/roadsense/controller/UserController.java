package com.roadsense.controller;

import com.roadsense.pojo.User;
import com.roadsense.service.UserService;
import com.roadsense.common.result.Result;
import com.roadsense.common.result.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 20:34
 */
@RestController
@RequestMapping("/users")
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

    @GetMapping
    public Result login(@RequestBody User user, HttpSession session){
        System.out.println("success");
        Result result = userService.login(user);

        if (Objects.equals(result.getCode(), CodeEnum.SUCCESS.getCode())){
            User user1 = (User) result.getData();
            session.setAttribute("user",user1);
        }

        System.out.println("result = " + result);

        return result;
    }

    @GetMapping("/{username}")
    public Result checkUserName(@PathVariable String username){
        Result result = userService.checkUserName(username);
        return result;
    }


    @PutMapping
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }

    @PostMapping
    @Transactional
    public Result modifyPassword(@RequestBody User user,HttpSession session){
        User user1 = (User) session.getAttribute("user");
        if (user1 == null){
            return new Result(CodeEnum.NOTLOGIN.getCode(), null,CodeEnum.NOTLOGIN.getMessage());
        }
        boolean flag = userService.modifyPassword(user);
        if (flag){
            return new Result(CodeEnum.SUCCESS.getCode(), null,CodeEnum.SUCCESS.getMessage());
        }else{
            return new Result(CodeEnum.FAILED.getCode(), null,"修改失败~请重试");
        }
    }

}
