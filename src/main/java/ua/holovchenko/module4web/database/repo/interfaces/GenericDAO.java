package ua.holovchenko.module4web.database.repo.interfaces;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();

    void save(T obj);

    void delete(T obj);
}
