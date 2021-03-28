package by.azot.asutp.api.dao;

import java.util.List;

import by.azot.asutp.entities.AEntity;

public interface IAGenericDao<T extends AEntity<Long>> {

    Class<T> getGenericClass();

    T create(T entity);

    T get(Long id);

    void update(T entity);

    void delete(T entity);
    
    List<T> getAll();
}
