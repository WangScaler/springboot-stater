package com.zytech.entity;

import lombok.Data;

/**
 * @Description：用户角色
 * @Author：chenyanbin
 * @Date：2021/1/2 11:46 下午
 * @Versiion：1.0
 */
@Data
public class UserRole {
    /**
     * 主键
     */
    private int id;
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 备注
     */
    private String remark;
}