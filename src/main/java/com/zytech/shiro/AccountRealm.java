package com.zytech.shiro;


import cn.hutool.core.bean.BeanUtil;
import com.zytech.entity.Role;
import com.zytech.entity.User;
import com.zytech.service.UserService;
import com.zytech.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("CustomRealm doGetAuthorizationInfo 授权");
        //获取用户名
        AccountProfile  principal = (AccountProfile) principals.getPrimaryPrincipal();
        String userName = principal.getUsername();
        User user = userService.findAllUserInfoByUserName(userName);
        if (user == null) {
            return null;
        }
        //角色集合
        List<String> stringRoleList = new ArrayList<>();
        //权限集合
        List<String> stringPermissionList = new ArrayList<>();
        List<Role> roleList = user.getRoleList();
        System.out.println(roleList);
        stringRoleList = roleList.stream().map(
                obj -> {
                    stringPermissionList.addAll(obj.getPermissionList()
                            .stream()
                            .map(per ->
                                    per.getName()).collect(Collectors.toList()));
                    return obj.getName();
                }).collect(Collectors.toList());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);
        return simpleAuthorizationInfo;


        }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("CustomRealm doGetAuthenticationInfo 认证");

        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.findSimpleUserInfoById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
