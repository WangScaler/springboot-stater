package com.zytech.entity;

import lombok.Data;

/**
 * @Description：角色权限
 * @Author：chenyanbin
 * @Date：2021/1/2 11:44 下午
 * @Versiion：1.0
 */
@Data
public class RolePermission {
    /**
     * 主键
     */
    private int id;
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 权限id
     */
    private int permissiionId;
}

