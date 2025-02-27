package by.mikhalachkin.servlet.filter;

import by.mikhalachkin.servlet.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;

    HttpSession session = req.getSession();

    User user = (User) session.getAttribute("user");

    String url = req.getRequestURL().toString();

    String method = req.getMethod();

    if (user != null || (url.contains("/login" ) && "GET".equalsIgnoreCase(method))) {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}
