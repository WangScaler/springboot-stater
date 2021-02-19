package com.zytech.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：角色
 * @Author：chenyanbin
 * @Date：2021/1/2 11:43 下午
 * @Versiion：1.0
 */
@Data
public class Role {
    /**
     * 主键
     */
    private int id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 权限集合
     */
    private List<Permission> permissionList = new ArrayList<>();
}