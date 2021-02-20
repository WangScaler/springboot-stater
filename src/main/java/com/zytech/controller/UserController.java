package com.zytech.controller;


import com.zytech.common.lang.Result;
import com.zytech.entity.User;
import com.zytech.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wangscaler
 * @since 2021-02-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequiresAuthentication
    @RequiresRoles("admin")
    @GetMapping("/index")
    public Result index() {
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
        User user = userService.findSimpleUserInfoById(1L);

        return Result.succ(user);
    }
    @RequiresAuthentication
    @RequiresRoles("admin")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        userService.saveUser(user);
        return Result.succ(user);
    }

}
