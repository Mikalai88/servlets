package by.mikhalachkin.servlet;

import by.mikhalachkin.servlet.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class EventsServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    User user = (User) req.getSession().getAttribute("user");

    HttpSession session = req.getSession();
    if (session.getAttribute("user") != null) {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Events</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Events:</h1>");
      out.println("Hello user: " + user.getLogin() + "<br>");
      out.println("Event 1 <br>");
      out.println("Event 2 <br>");
      out.println("Event 3 <br>");
      out.println("Event 4 <br>");
      out.println("Event 5 <br>");
      out.println("</body>");
      out.println("</html>");
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
}
