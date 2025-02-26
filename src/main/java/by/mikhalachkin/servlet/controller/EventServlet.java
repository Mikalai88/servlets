package by.mikhalachkin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class EventServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    String name = req.getParameter("name");

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet Event</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Event with name: " + name + " and id: " + id);
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
