package com.zytech.service.impl;

import com.zytech.entity.Role;
import com.zytech.entity.User;
import com.zytech.mapper.RoleMapper;
import com.zytech.mapper.UserMapper;
import com.zytech.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wangscaler
 * @since 2021-02-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findAllUserInfoByUserName(String userName) {
        User user = userMapper.findByUserName(userName);
        //用户角色的集合
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public User findSimpleUserInfoById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User findSimpleUserInfoByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
