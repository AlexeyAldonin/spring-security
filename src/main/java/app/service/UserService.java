package app.service;

import app.model.User;

import java.util.List;

public interface UserService extends EntityService<User> {

    void save(User user);

    void delete(Long id);

    User getById(Long id);

    void update(User user);

    List<User> getAll();
}
