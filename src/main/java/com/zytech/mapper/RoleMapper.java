package com.zytech.mapper;

import com.zytech.entity.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 角色
 */
public interface RoleMapper {
    /**
     * 根据用户查询所有的角色
     *
     * @param userId 用户id
     * @return
     */
    @Select("select r.id id,r.name name,r.description description  from  user_role ur " +
            "left join role r on ur.role_id=r.id " +
            "where ur.user_id=#{userId}")
    @Results(
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "permissionList", column = "id",
                            many = @Many(select = "com.zytech.mapper.PermissionMapper.findByPermissionListByRoleId",
                                    fetchType = FetchType.DEFAULT))
            }
    )
    List<Role> findRoleListByUserId(@Param("userId") Long userId);
}

