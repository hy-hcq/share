package com.hy.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.hy.reggie.commen.BaseContext;
import com.hy.reggie.commen.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否登录
 */

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取URI
        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}", request.getRequestURI());

        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };

        //判断请求路径是否需要处理
        boolean check = check(requestURI, urls);

        //无需处理
        if (check) {
            log.info("本次请求无需处理：{}", request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        //判断登录状态
        if (request.getSession().getAttribute("employee") != null) {//不为空
            log.info("用户已经登录，ID为：{}", request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            long id = Thread.currentThread().getId();
            log.info("线程ID：{}", id);




            filterChain.doFilter(request, response);
            return;
        }

        //未登录
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));


    }

    //检查本次请求是否需要放行
    public boolean check(String requestURI, String[] urls) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
