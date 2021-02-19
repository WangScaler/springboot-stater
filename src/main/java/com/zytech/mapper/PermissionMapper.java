package com.zytech.mapper;

import com.zytech.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限
 */
public interface PermissionMapper {
    /**
     * 根据roleId查询所有权限
     * @param roleId
     * @return
     */
    @Select("select p.id id,p.name name,p.url url from role_permission rp " +
            "left join permission p on rp.permission_id=p.id " +
            "where rp.role_id=#{roleId}")
    List<Permission> findByPermissionListByRoleId(@Param("roleId") int roleId);
}
