package app.repository;

import app.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        entityManager
                .createQuery("DELETE FROM User WHERE id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public User getByName(String name) {
        return (User) entityManager
                .createQuery("SELECT u FROM User u WHERE u.name=(: name)")
                .setParameter("name", name)
                .getSingleResult();
    }
}
