package com.zytech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zytech.entity.SysLog;
import com.zytech.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wangscaler
 * @since 2021-02-19
 */
public interface SysLogService extends IService<SysLog> {

    void saveSysLog(SysLog sysLog);
}

