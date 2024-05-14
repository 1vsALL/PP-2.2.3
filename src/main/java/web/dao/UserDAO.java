package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> listUsers();

    void addUser(User user);

    User userID(int id);

    void removeUserById(int id);

    void update(User user, int id);
}
