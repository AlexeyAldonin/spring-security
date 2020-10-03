package app.repository;

import java.util.List;

public interface Dao<T> {

    void save(T t);

    T getById(Long id);

    void deleteById(Long id);

    void update(T t);

    List<T> getAll();
}
