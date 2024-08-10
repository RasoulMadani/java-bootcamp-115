package ir.maktabsharif.repository;

import ir.maktabsharif.entity.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityRepository<T extends BaseEntity<ID>,ID> {

    T update(T entity);

    T[] findAll();

    T findById(ID id) throws SQLException;

    long count() throws SQLException;

    void deleteAll() throws SQLException;

    boolean deleteById(ID id) throws SQLException;

    boolean existsById(ID id) throws SQLException;

}
