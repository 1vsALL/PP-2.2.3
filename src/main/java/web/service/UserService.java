package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void addUser(User user);

    User userID(int id);
}
