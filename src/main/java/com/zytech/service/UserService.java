package com.zytech.service;

import com.zytech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wangscaler
 * @since 2021-02-19
 */
public interface UserService extends IService<User> {
    /**
     * 获取全部用户信息，包括角色、权限
     * @param userName
     * @return
     */
    User findAllUserInfoByUserName(String userName);

    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    User findSimpleUserInfoById(Long userId);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User findSimpleUserInfoByUserName(String userName);

    void saveUser(User user);
}

