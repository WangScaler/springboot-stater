package com.zytech.mapper;

import com.zytech.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wangscaler
 * @since 2021-02-19
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return
     */
    @Select("select * from user where username=#{userName}")
    User findByUserName(@Param("userName") String userName);

    /**
     * 根据主键查询用户
     *
     * @param id 主键
     * @return
     */
    @Select("select * from user where id=#{userId}")
    User findById(@Param("userId") Long id);

    /**
     * 根据用户名和密码查询用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Select("select * from user where userName=#{userName} and password=#{password}")
    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    void saveUser(User user);
}

