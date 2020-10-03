package app.service;

import java.util.List;

public interface EntityService<T> {
    void save(T t);

    void delete(Long id);

    T getById(Long id);

    void update(T t);

    List<T> getAll();
}
