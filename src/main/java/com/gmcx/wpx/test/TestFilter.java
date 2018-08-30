package com.gmcx.wpx.test;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wpx on 2017/7/5.
 */
public class TestFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestFilter init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFilter doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        System.out.println("TestFilter destroy");
    }
}
