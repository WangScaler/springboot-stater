package com.zytech.controller;


import cn.hutool.crypto.SecureUtil;
import com.zytech.common.annotation.Log;
import com.zytech.common.annotation.Log;
import com.zytech.common.lang.Result;
import com.zytech.entity.Role;
import com.zytech.entity.User;
import com.zytech.entity.UserRole;
import com.zytech.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author WangScaler
 * @since 2021-02-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Log("/user/index")
    @RequiresAuthentication
    @RequiresRoles("admin")
    @GetMapping("/index")
    public Result index() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello", "world");
        String hello = operations.get("hello");
        System.out.println(hello);
        User user = userService.findSimpleUserInfoById(51L);

        return Result.succ(user);
    }

    @Log("/user/save")
    @RequiresAuthentication
    @RequiresRoles("admin")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        System.out.println(user);
        User user1 = userService.findSimpleUserInfoByUserName(user.getUsername());
        if (user1 != null) {
            return Result.fail("用户已存在");
        }
        user.setPassword(SecureUtil.md5(user.getPassword()));
//        UserRole userRole =new UserRole();
//        List<Role> roleList = new ArrayList<>();
////        roleList = user.getRoleList();
//        Role role = roleList.get(0);;
//        userRole.setRoleId(role.getId());
        userService.saveUser(user);
//        User newuser = userService.findSimpleUserInfoByUserName(user.getUsername());
//        userRole.setUserId(newuser.getId());
//        userService.saveUserRole(userRole);
        return Result.succ(user);
    }


    @Log("/user/test")
    @RequiresAuthentication
    @RequiresRoles("admin")
    @PostMapping("/test")
    public Result test(@Validated User user) {
        System.out.println(user);
        return Result.succ(user);
    }

}
