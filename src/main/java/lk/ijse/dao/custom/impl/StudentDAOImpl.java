package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Student VALUES(?,?,?,?)",
                dto.getId(),dto.getName(),dto.getAddress(),dto.getPhone_number());
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Student SET name = ?,address = ?,phone_number = ? WHERE id = ?",dto.getName(),
                dto.getAddress(),dto.getPhone_number(),dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Student WHERE id = ?",id);
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Student WHERE id = ?",id);

        Student entity = null;
        if (resultSet.next()) {
            int Sid = Integer.parseInt(resultSet.getString(1));
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int phoneNumber = Integer.parseInt(resultSet.getString(4));

            entity = new Student(Sid,name,address,phoneNumber);
        }
        return entity;
    }
}
