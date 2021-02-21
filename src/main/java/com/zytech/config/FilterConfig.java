package com.zytech.config;
import com.zytech.common.xss.XssFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * 设置跨站脚本过滤
 */
@Configuration
public class FilterConfig {
    @Value("${xss.enabled}")
    private String enabled;

    @Value("${xss.excludes}")
    private String excludes;

    @Value("${xss.urlPatterns}")
    private String urlPatterns;

    @Bean
    public FilterRegistrationBean xssFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        registrationBean.setFilter(new XssFilter());
        registrationBean.addUrlPatterns(StringUtils.split(urlPatterns,","));
        registrationBean.setName("XssFilter");
        registrationBean.setOrder(9999);
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("excludes",excludes);
        initParameters.put("enabled",enabled);
        registrationBean.setInitParameters(initParameters);
        return registrationBean;
    }
}

