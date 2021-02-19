package com.zytech.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description：接收用户名和密码
 * @Author：chenyanbin
 * @Date：2021/1/3 6:19 下午
 * @Versiion：1.0
 */
@Data
public class UserQuery implements Serializable {
    private String userName;
    private String password;
}