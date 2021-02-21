package com.zytech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zytech.entity.Role;
import com.zytech.entity.SysLog;
import com.zytech.entity.User;
import com.zytech.mapper.RoleMapper;
import com.zytech.mapper.SysLogMapper;
import com.zytech.mapper.UserMapper;
import com.zytech.service.SysLogService;
import com.zytech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WangScaler
 * @since 2021-02-19
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;


    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogMapper.saveSysLog(sysLog);
    }

}
