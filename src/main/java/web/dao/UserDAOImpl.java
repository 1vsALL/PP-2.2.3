package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User userID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(User user, int id) {
        User updated = entityManager.find(User.class, id);
        updated.setName(user.getName());
        updated.setLastName(user.getLastName());
        updated.setAge(user.getAge());
    }
}
