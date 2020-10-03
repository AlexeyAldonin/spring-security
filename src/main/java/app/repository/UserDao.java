package app.repository;

import app.model.User;

import java.util.List;


public interface UserDao  extends Dao<User>{
    @Override
    void save(User user);

    @Override
    User getById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    void update(User user);

    @Override
    List<User> getAll();

    User getByName(String name);
}
