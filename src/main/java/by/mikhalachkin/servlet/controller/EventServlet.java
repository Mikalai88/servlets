package by.mikhalachkin.servlet.controller;

import by.mikhalachkin.servlet.model.Event;
import by.mikhalachkin.servlet.service.EventService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class EventServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));

    EventService eventService = new EventService();
    Event event = eventService.getEvent(id);

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet Event</title>");
    out.println("</head>");
    out.println("<body>");
    out.println(event.toString());
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
