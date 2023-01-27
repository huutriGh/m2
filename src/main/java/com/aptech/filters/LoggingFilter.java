package com.aptech.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(value = "/*",asyncSupported = true)
public class LoggingFilter implements Filter {

    static Logger logger = LogManager.getLogger(LoggingFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        var wrapper = new LogRequestWrapper(req,logger);
        logger.debug(String.format("Request made to %s, %s",req.getRequestURI(), req.getHeader("accept-encoding")));
        filterChain.doFilter(wrapper,servletResponse);
    }

}
