package by.mikhalachkin.servlet.service;

import by.mikhalachkin.servlet.model.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventService {
  private List<Event> events;

  public EventService() {
    events = new ArrayList<>();

    Event event1 = new Event(1, "Concert Depeche Mode", LocalDate.of(2025, 3, 10));
    Event event2 = new Event(2, "Concert Annalisa", LocalDate.of(2025, 6, 7));
    Event event3 = new Event(3, "Concert Jack Savoretti", LocalDate.of(2025, 5, 18));
    Event event4 = new Event(4, "Concert Vendredi sur mer", LocalDate.of(2025, 5, 22));

    events.add(event1);
    events.add(event2);
    events.add(event3);
    events.add(event4);
  }

  public List<Event> getEvents() {
    return events;
  }

  public Event getEvent(int id) {
    for (Event event : events) {
      if (event.getId() == id) {
        return event;
      }
    }

    return null;
  }
}
