package ir.maktabsharif.repository;

import ir.maktabsharif.entity.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityRespository {

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    BaseEntity[] findAll();

    BaseEntity findById(Long id) throws SQLException;

    long count() throws SQLException;

    void deleteAll() throws SQLException;

    boolean deleteById(Long id) throws SQLException;

    boolean existsById(Long id) throws SQLException;

}
