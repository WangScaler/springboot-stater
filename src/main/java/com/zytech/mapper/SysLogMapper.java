package com.zytech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zytech.entity.SysLog;
import com.zytech.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WangScaler
 * @since 2021-02-19
 */
public interface SysLogMapper extends BaseMapper<SysLog> {
    void saveSysLog(SysLog sysLog);
}

