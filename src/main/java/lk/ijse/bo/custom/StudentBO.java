package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDto;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {

    boolean save(StudentDto dto) throws SQLException;

    boolean update(StudentDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    StudentDto searchStudents(String id) throws SQLException, ClassNotFoundException;
}
