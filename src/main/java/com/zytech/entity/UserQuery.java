package com.zytech.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description：接收用户名和密码
 * @Author：WangScaler
 * @Date：2021/02/19 6:19 下午
 * @Versiion：1.0
 */
@Data
public class UserQuery implements Serializable {
    private String userName;
    private String password;
}