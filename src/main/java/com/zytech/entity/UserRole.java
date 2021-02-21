package com.zytech.entity;

import lombok.Data;

/**
 * @Description：用户角色
 * @Author：WangScaler
 * @Date：2021/02/19 11:46 下午
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
    private Long userId;
    /**
     * 备注
     */
    private String remark;
}