package by.mikhalachkin.servlet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
  private Integer id;
  private String name;
  private LocalDate date;
}
