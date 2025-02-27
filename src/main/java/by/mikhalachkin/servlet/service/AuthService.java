package by.mikhalachkin.servlet.service;

import by.mikhalachkin.servlet.model.User;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
  private List<User> users;

  public AuthService() {
    users = new ArrayList<User>();

    User Nikolai = new User("Nikolai", "qwert");

    users.add(Nikolai);
  }

  public boolean authenticate(String login, String password) {
    if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
      return false;
    }

    for (User user : users) {
      if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
        return true;
      }
    }

    return false;
  }
}
