package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Student;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean save(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDAO.save(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getPhone_number()));
    }

    @Override
    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getPhone_number()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDto searchStudents(String id) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.search(id);
        if (student != null) {
            return new StudentDto(student.getId(), student.getName(), student.getAddress(), student.getPhone_number());
        } else {
            return null;
        }
    }
}
