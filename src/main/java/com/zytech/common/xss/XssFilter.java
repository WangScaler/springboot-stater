package com.zytech.common.xss;

import com.zytech.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // There will be code for XssHttpServletRequestWrapper. This class is defined by itself.
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
    }

}