package com.zytech.entity;

import lombok.Data;

/**
 * @Description：权限
 * @Author：WangScaler
 * @Date：2021/02/19 11:47 下午
 * @Versiion：1.0
 */
@Data
public class Permission {
    /**
     * 主键
     */
    private int id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 路径
     */
    private String url;
}