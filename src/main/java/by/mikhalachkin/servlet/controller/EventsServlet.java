package by.mikhalachkin.servlet.controller;

import by.mikhalachkin.servlet.model.Event;
import by.mikhalachkin.servlet.service.EventService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EventsServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    EventService eventService = new EventService();

    List<Event> events = eventService.getEvents();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet Events</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Events:</h1>");

    for (Event event : events) {
      out.println(event.getName() + " at " + event.getDate() + "<br>");
    }

    out.println("</body>");
    out.println("</html>");

    out.close();
  }
}
