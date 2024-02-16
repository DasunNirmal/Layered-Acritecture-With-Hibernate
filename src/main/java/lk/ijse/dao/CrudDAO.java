package lk.ijse.dao;

import lk.ijse.entity.Student;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {

    void save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    Student search(String id) throws SQLException, ClassNotFoundException;
}
