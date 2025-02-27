package by.mikhalachkin.servlet.controller;

import by.mikhalachkin.servlet.model.User;
import by.mikhalachkin.servlet.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    resp.setContentType("text/html");

    PrintWriter out = resp.getWriter();

    AuthService authService = new AuthService();

    if (authService.authenticate(login, password)) {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet LoginServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("Hello " + login + "! Your password is " + password);
      out.println("</body>");
      out.println("</html>");

      User user = new User(login, password);

      HttpSession session = req.getSession();
      session.setAttribute("user", user);

    } else {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet LoginServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("Access denied");
      out.println("</body>");
      out.println("</html>");
    }

    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String data = "";

    BufferedReader reader = req.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
      data += line;
    }

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet LoginServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println(data);
    out.println("</body>");
    out.println("</html>");

    out.close();
  }
}
