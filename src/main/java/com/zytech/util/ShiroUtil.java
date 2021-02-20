package com.zytech.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zytech.entity.User;
import com.zytech.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

import static org.apache.shiro.SecurityUtils.getSubject;

public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) getSubject().getPrincipal();
    }

}
