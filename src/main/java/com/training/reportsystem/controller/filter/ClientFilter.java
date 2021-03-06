package com.training.reportsystem.controller.filter;

import com.training.reportsystem.model.entity.Role;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter(value = "/app/client/*")
public class ClientFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Optional<User> user = Optional.ofNullable((User) request.getSession().getAttribute(Attributes.USER));
        if (!user.isPresent() || !user.get().getRole().isPresent() || !user.get().getRole().get().equals(Role.CLIENT)) {
            response.sendRedirect(Pages.LOGIN_REDIRECT);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
